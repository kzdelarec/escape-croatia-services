package hr.tvz.zdelarec.escapecroatioaservices.controller;

import hr.tvz.zdelarec.escapecroatioaservices.dto.AuthorityDto;
import hr.tvz.zdelarec.escapecroatioaservices.dto.PlatformUserDto;
import hr.tvz.zdelarec.escapecroatioaservices.enumeration.Permission;
import hr.tvz.zdelarec.escapecroatioaservices.service.authorityService.AuthorityService;
import hr.tvz.zdelarec.escapecroatioaservices.service.platformUser.PlatformUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
     * autowired {@link AuthorityService}.
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
        for (String authority : platformUser.getAuthorities()) {
            final AuthorityDto newAuthority = new AuthorityDto();
            newAuthority.setUsername(platformUser.getUsername());
            newAuthority.setAuthority(authority);
            authorityService.save(newAuthority);
        }

        platformUserDto.setUsername(platformUser.getUsername());
        platformUserDto.setEnabled(platformUser.getEnabled());
        platformUserService.save(platformUserDto);

        return "dashboard";
    }
}
