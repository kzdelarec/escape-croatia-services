package hr.tvz.zdelarec.escapecroatioaservices.service.emailService;

import hr.tvz.zdelarec.escapecroatioaservices.dto.ConfirmationTokenDto;

/**
 * Email service.
 *
 * @author kristijan.zdelarec
 */
public interface EmailService {

    /**
     * Method for sending confirmation emails.
     * @param confirmationToken {@link ConfirmationTokenDto}
     */
    void sendConfirmationMail(ConfirmationTokenDto confirmationToken);

}
