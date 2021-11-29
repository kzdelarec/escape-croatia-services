package hr.tvz.zdelarec.escapecroatioaservices.controller;

import hr.tvz.zdelarec.escapecroatioaservices.dto.ConfirmationTokenDto;
import hr.tvz.zdelarec.escapecroatioaservices.dto.PasswordResetDto;
import hr.tvz.zdelarec.escapecroatioaservices.dto.PlatformUserDto;
import hr.tvz.zdelarec.escapecroatioaservices.service.confirmationTokenService.ConfirmationTokenService;
import hr.tvz.zdelarec.escapecroatioaservices.service.platformUser.PlatformUserService;
import hr.tvz.zdelarec.escapecroatioaservices.validator.PasswordResetValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Contains mappings related to the user confirmation actions.
 *
 * @author kristijan.zdelarec
 */
@Controller
@RequestMapping(value = {"/confirmation"})
public class ConfirmationController {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ConfirmationController.class);

    /**
     * Dto name.
     */
    private static final String PASSWORD_RESET_DTO = "passwordResetDto";

    /**
     * Autowired {@link PlatformUserService}.
     */
    @Autowired
    private PlatformUserService platformUserService;

    /**
     * Autowired {@link ConfirmationTokenService}.
     */
    @Autowired
    private ConfirmationTokenService confirmationTokenService;


    /**
     * Autowired {@link PasswordResetValidator}.
     */
    @Autowired
    private PasswordResetValidator passwordResetValidator;

    /**
     * Adds a {@link PasswordResetValidator} validator bean to the web data binder for model attribute with name {@link #PASSWORD_RESET_DTO}.
     *
     * @param binder {@link WebDataBinder} object
     */
    @InitBinder(PASSWORD_RESET_DTO)
    protected void initBinder(final WebDataBinder binder) {
        binder.addValidators(passwordResetValidator);
    }

    /**
     * Request for password change.
     * @param model model
     * @param token confirmation token
     * @return view name
     */
    @GetMapping("/{token}")
    public String confirmRegistration(final Model model, @PathVariable("token") final String token) {
        final PasswordResetDto passwordResetDto = new PasswordResetDto();
        final ConfirmationTokenDto confirmationTokenDto = confirmationTokenService.getByToken(token);
        passwordResetDto.setToken(confirmationTokenDto.getToken());

        model.addAttribute(PASSWORD_RESET_DTO, passwordResetDto);

        return "resetPassword";
    }

    /**
     * Submit for password change.
     * @param passwordResetDto {@link PasswordResetDto} object.
     * @param bindingResult validations
     * @param model model
     * @return redirect to success screen
     */
    @PostMapping("/resetPassword")
    public String resetPassword(@Validated @ModelAttribute(PASSWORD_RESET_DTO) final PasswordResetDto passwordResetDto, final BindingResult bindingResult, final Model model) {
        if (bindingResult.hasErrors()) {
            LOGGER.debug("User registration form has errors");
            model.addAttribute(PASSWORD_RESET_DTO, passwordResetDto);
            return "resetPassword";
        }

        final ConfirmationTokenDto confirmationTokenDto = confirmationTokenService.getByToken(passwordResetDto.getToken());
        final PlatformUserDto platformUserDto = platformUserService.getById(confirmationTokenDto.getUserId().longValue());

        platformUserDto.setPassword(new BCryptPasswordEncoder().encode(passwordResetDto.getPassword()));
        platformUserDto.setEnabled(true);

        platformUserService.save(platformUserDto);

        LOGGER.debug("User activation completed for: {}", platformUserDto.getUsername());

        confirmationTokenService.deleteByToken(confirmationTokenDto.getToken());
        return "registrationSuccess";
    }
}
