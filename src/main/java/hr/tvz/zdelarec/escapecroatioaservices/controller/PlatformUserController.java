package hr.tvz.zdelarec.escapecroatioaservices.controller;

import hr.tvz.zdelarec.escapecroatioaservices.dto.AuthorityDto;
import hr.tvz.zdelarec.escapecroatioaservices.dto.PlatformUserDto;
import hr.tvz.zdelarec.escapecroatioaservices.enumeration.Permission;
import hr.tvz.zdelarec.escapecroatioaservices.service.authorityService.AuthorityService;
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
        model.addAttribute("platformUser", platformUserDto);
        model.addAttribute("allPermissions", Permission.values());
        return "editUser";
    }

    /**
     * Saves edited platform user.
     * @param model view model
     * @param platformUser {@link PlatformUserDto} object to be saved.
     * @return view name
     */
    @PostMapping(path = "/save")
    public String saveUser(final Model model, @Validated final PlatformUserDto platformUser) {
        LOGGER.debug("Showing cities page");
        final PlatformUserDto platformUserDto = platformUserService.getById(platformUser.getId());
        authorityService.deleteAllByUsername(platformUserDto.getUsername());
        final  List<AuthorityDto> authorityDtoList = new ArrayList<>();
        for (String authority : platformUser.getAuthorities()) {
            final AuthorityDto newAuthority = new AuthorityDto();
            newAuthority.setUsername(platformUser.getUsername());
            newAuthority.setAuthority(authority);
            authorityDtoList.add(newAuthority);
        }

        platformUserDto.setUsername(platformUser.getUsername());
        platformUserDto.setEnabled(platformUser.getEnabled());
        if (platformUserService.save(platformUserDto) != null) {
            authorityService.saveAll(authorityDtoList);
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
        final  List<AuthorityDto> authorityDtoList = new ArrayList<>();
        for (String authority : platformUser.getAuthorities()) {
            final AuthorityDto newAuthority = new AuthorityDto();
            newAuthority.setUsername(platformUser.getUsername());
            newAuthority.setAuthority(authority);
            authorityDtoList.add(newAuthority);
        }

        if (platformUserService.save(platformUser) != null) {
            authorityService.saveAll(authorityDtoList);
        }

        return "redirect:/userAdministration";
    }
}
