package hr.tvz.zdelarec.escapecroatioaservices.validator;

import hr.tvz.zdelarec.escapecroatioaservices.dto.PasswordResetDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * Password Reset DTO validator.
 *
 * @author kristijan.zdelarec
 */
@Component
public class PasswordResetValidator implements Validator {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PasswordResetValidator.class);

    /**
     * Validation field.
     */
    private static final String PASSWORD_CONFIRM = "passwordConfirm";


    @Override
    public boolean supports(final Class<?> clazz) {
        return PasswordResetDto.class.equals(clazz);
    }

    @Override
    public void validate(final Object target, final Errors errors) {
        if (errors.hasErrors()) {
            LOGGER.debug("Password reset dto already has errors");
            return;
        }

        LOGGER.debug("Validating password reset dto");
        final PasswordResetDto passwordResetDto = (PasswordResetDto) target;

        // Passwords must match
        if (!Objects.equals(passwordResetDto.getPassword(), passwordResetDto.getPasswordConfirm())) {
            LOGGER.debug("Passwords do not match");
            errors.rejectValue(PASSWORD_CONFIRM, "Passwords must match!");
        }
    }
}