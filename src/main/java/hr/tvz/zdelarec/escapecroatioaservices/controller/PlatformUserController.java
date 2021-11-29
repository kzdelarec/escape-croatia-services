package hr.tvz.zdelarec.escapecroatioaservices.controller;

import hr.tvz.zdelarec.escapecroatioaservices.dto.AccessControlDto;
import hr.tvz.zdelarec.escapecroatioaservices.dto.AuthorityDto;
import hr.tvz.zdelarec.escapecroatioaservices.dto.ConfirmationTokenDto;
import hr.tvz.zdelarec.escapecroatioaservices.dto.PlatformUserDto;
import hr.tvz.zdelarec.escapecroatioaservices.enumeration.Permission;
import hr.tvz.zdelarec.escapecroatioaservices.service.accessControl.AccessControlService;
import hr.tvz.zdelarec.escapecroatioaservices.service.authorityService.AuthorityService;
import hr.tvz.zdelarec.escapecroatioaservices.service.confirmationTokenService.ConfirmationTokenService;
import hr.tvz.zdelarec.escapecroatioaservices.service.emailService.EmailService;
import hr.tvz.zdelarec.escapecroatioaservices.service.place.PlaceService;
import hr.tvz.zdelarec.escapecroatioaservices.service.platformUser.PlatformUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Contains mappings related to the user administration.
 *
 * @author kristijan.zdelarec
 */
@Controller
@RequestMapping(value = {"/userAdministration"})
public class PlatformUserController {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PlatformUserController.class);

    /**
     * Autowired {@link PlatformUserService}.
     */
    @Autowired
    private PlatformUserService platformUserService;

    /**
     * Autowired {@link AuthorityService}.
     */
    @Autowired
    private AuthorityService authorityService;

    /**
     * Autowired {@link ConfirmationTokenService}.
     */
    @Autowired
    private ConfirmationTokenService confirmationTokenService;

    /**
     * Autowired {@link EmailService}.
     */
    @Autowired
    private EmailService emailService;

    /**
     * Autowired {@link AccessControlService}.
     */
    @Autowired
    private AccessControlService accessControlService;

    /**
     * Autowired {@link PlaceService}.
     */
    @Autowired
    private PlaceService placeService;


    /**
     * Get all platform users.
     *
     * @param model view model
     * @return view name
     */
    @GetMapping
    public String displayUsers(final Model model) {
        LOGGER.debug("Showing platform users");
        final List<PlatformUserDto> platformUserDtoList = platformUserService.getAllUsers();
        model.addAttribute("platformUsers", platformUserDtoList);
        return "userAdministration";
    }

    /**
     * Displays form for a new platform user.
     * @param model view model
     * @return view name
     */
    @GetMapping(path = "/new")
    public String newUser(final Model model) {
        LOGGER.debug("Showing cities page");
        final PlatformUserDto platformUserDto = new PlatformUserDto();
        model.addAttribute("platformUser", platformUserDto);
        model.addAttribute("allPermissions", Permission.values());
        model.addAttribute("allPlaces", placeService.getAllPlaces());
        return "newUser";
    }

    /**
     * Displays edit form for a platform user.
     * @param model view model
     * @param id platform user identifier
     * @return view name
     */
    @GetMapping(path = "/edit/{id}")
    public String editUser(final Model model, @PathVariable("id") final Long id) {
        LOGGER.debug("Showing cities page");
        final PlatformUserDto platformUserDto = platformUserService.getById(id);
        platformUserDto.setAuthorities(authorityService.getPermissionByUsername(platformUserDto.getUsername()).stream().map(AuthorityDto::getAuthority).collect(Collectors.toList()));
        platformUserDto.setAccessPlaceIds(accessControlService.getAccessByUserId(id.intValue()).stream().map(AccessControlDto::getPlaceId).collect(Collectors.toList()));
        model.addAttribute("platformUser", platformUserDto);
        model.addAttribute("allPermissions", Permission.values());
        model.addAttribute("allPlaces", placeService.getAllPlaces());
        return "editUser";
    }

    /**
     * Disabled the user and removes all of his authorities.
     * @param model view model
     * @param id platform user identifier
     * @return redirect
     */
    @GetMapping(path = "/block/{id}")
    public String blockUser(final Model model, @PathVariable("id") final Long id) {
        final PlatformUserDto platformUserDto = platformUserService.getById(id);
        LOGGER.debug("Blocking platform user with username {}", platformUserDto.getUsername());
        authorityService.deleteAllByUsername(platformUserDto.getUsername());
        accessControlService.deleteAllByUserId(platformUserDto.getId().intValue());
        platformUserDto.setEnabled(false);
        platformUserService.save(platformUserDto);
        return "redirect:/userAdministration";
    }

    /**
     * Saves edited platform user.
     * @param model view model
     * @param platformUser {@link PlatformUserDto} object to be saved.
     * @return view name
     */
    @PostMapping(path = "/save")
    public String saveUser(final Model model, @Validated final PlatformUserDto platformUser) {
        LOGGER.debug("Saving user {}", platformUser.getUsername());
        final PlatformUserDto platformUserDto = platformUserService.getById(platformUser.getId());
        if (!platformUser.getUsername().equals(platformUserDto.getUsername())) {
            authorityService.deleteAllByUsername(platformUserDto.getUsername());
        }

        final List<AuthorityDto> authorityDtoList = getAuthorityDtos(platformUser);

        final List<AccessControlDto> accessControlDtoList = getAccessControlDtos(platformUser);

        platformUserDto.setUsername(platformUser.getUsername());
        platformUserDto.setEnabled(platformUser.getEnabled());
        platformUserDto.setEmail(platformUser.getEmail());
        if (platformUserService.save(platformUserDto) != null) {
            authorityService.saveAll(authorityDtoList, platformUserDto.getUsername());
            accessControlService.saveAll(accessControlDtoList, platformUser.getId().intValue());
        }

        return "redirect:/userAdministration";
    }

    /**
     * Saves new platform user.
     * @param model view model
     * @param platformUser {@link PlatformUserDto} object to be saved.
     * @return view name
     */
    @PostMapping(path = "/register")
    public String registerUser(final Model model, @Validated final PlatformUserDto platformUser) {
        LOGGER.debug("Showing cities page");
        platformUser.setPassword(new BCryptPasswordEncoder().encode(LocalDateTime.now().toString()));

        final PlatformUserDto registeredUser = platformUserService.save(platformUser);

        if ( registeredUser != null) {
            platformUser.setId(registeredUser.getId());
            authorityService.saveAll(getAuthorityDtos(platformUser), registeredUser.getUsername());
            accessControlService.saveAll(getAccessControlDtos(platformUser), platformUser.getId().intValue());
            createTokenAndSendMail(registeredUser.getId());
        }

        return "redirect:/userAdministration";
    }

    /**
     * Method for creating new {@link ConfirmationTokenDto} and for sending email.
     * @param id platform user identifier
     */
    private void createTokenAndSendMail(final Long id) {
        LOGGER.debug("Creating new token");
        final ConfirmationTokenDto confirmationTokenDto = new ConfirmationTokenDto();
        confirmationTokenDto.setToken(UUID.randomUUID().toString());
        confirmationTokenDto.setUserId(id.intValue());
        confirmationTokenService.save(confirmationTokenDto);
        LOGGER.debug("Created confirmation token {}", confirmationTokenDto.getToken());
        emailService.sendConfirmationMail(confirmationTokenDto);
        LOGGER.debug("Sending email");
    }

    /**
     * Generates {@link AccessControlDto} objects from form input.
     * @param platformUser user
     * @return list of {@link AccessControlDto} objects
     */
    private List<AccessControlDto> getAccessControlDtos(@Validated final PlatformUserDto platformUser) {
        final  List<AccessControlDto> accessControlDtoList = new ArrayList<>();
        for (Integer accessPlaceId : platformUser.getAccessPlaceIds()) {
            final AccessControlDto accessControlDto = new AccessControlDto();
            accessControlDto.setPlaceId(accessPlaceId);
            accessControlDto.setUserId(platformUser.getId().intValue());
            accessControlDtoList.add(accessControlDto);
        }
        return accessControlDtoList;
    }

    /**
     * Generates {@link AuthorityDto} objects from form input.
     * @param platformUser user
     * @return list of {@link AuthorityDto} objects
     */
    private List<AuthorityDto> getAuthorityDtos(@Validated final PlatformUserDto platformUser) {
        final List<AuthorityDto> authorityDtoList = new ArrayList<>();
        for (String authority : platformUser.getAuthorities()) {
            final AuthorityDto newAuthority = new AuthorityDto();
            newAuthority.setUsername(platformUser.getUsername());
            newAuthority.setAuthority(authority);
            authorityDtoList.add(newAuthority);
        }
        return authorityDtoList;
    }

}
