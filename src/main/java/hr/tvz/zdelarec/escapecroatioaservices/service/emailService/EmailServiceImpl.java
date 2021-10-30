package hr.tvz.zdelarec.escapecroatioaservices.service.emailService;

import hr.tvz.zdelarec.escapecroatioaservices.config.EmailConfig;
import hr.tvz.zdelarec.escapecroatioaservices.dto.ConfirmationTokenDto;
import hr.tvz.zdelarec.escapecroatioaservices.dto.PlatformUserDto;
import hr.tvz.zdelarec.escapecroatioaservices.service.confirmationTokenService.ConfirmationTokenService;
import hr.tvz.zdelarec.escapecroatioaservices.service.platformUser.PlatformUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * {@link EmailService} implementation.
 *
 * @author kristijan.zdelarec
 */
@Service
public class EmailServiceImpl implements EmailService {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(EmailService.class);

    private static final String MAIL_SENDER = "escape-croatia@noreplay.com";
    private static final String CONFIRMATION_SUBJECT = "Your registration is successful";
    private static final String CONFIRMATION_TEMPLATE = "emailTemplate.html";
    private static final String USERNAME_PLACEHOLDER = "%USERNAME%";
    private static final String TOKEN_PLACEHOLDER = "%TOKEN%";

    /**
     * Autowired {@link ConfirmationTokenService}.
     */
    @Autowired
    private ConfirmationTokenService confirmationTokenService;

    /**
     * Autowired {@link ConfirmationTokenService}.
     */
    @Autowired
    private PlatformUserService platformUserService;


    /**
     * Autowired {@link EmailConfig}.
     */
    @Autowired
    private EmailConfig emailConfig;


    @Override
    @Async
    public void sendConfirmationMail(final ConfirmationTokenDto confirmationTokenDto) {
        final PlatformUserDto platformUserDto = platformUserService.getById(confirmationTokenDto.getUserId().longValue());
        final JavaMailSenderImpl mailSender = configMailServer();
        final MimeMessage mailMessage = configureMailMessage(platformUserDto, confirmationTokenDto, mailSender);

        mailSender.send(mailMessage);
        LOGGER.debug("Confirmation mail sent to {}", platformUserDto.getEmail());
    }

    /**
     * Method for initializing email server.
     * @return configured {@link JavaMailSenderImpl} object.
     */
    private JavaMailSenderImpl configMailServer() {
        final JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(emailConfig.getHost());
        mailSender.setPort(emailConfig.getPort());
        mailSender.setUsername(emailConfig.getUsername());
        mailSender.setPassword(emailConfig.getPassword());

        final Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", emailConfig.getProtocol());
        props.put("mail.smtp.auth", emailConfig.getAuth());
        props.put("mail.smtp.starttls.enable", emailConfig.getTls());
        return mailSender;
    }

    /**
     * Method for configuring email.
     * @param platformUserDto {@link PlatformUserDto} object
     * @param confirmationTokenDto {@link ConfirmationTokenDto} object
     * @param mailSender {@link JavaMailSenderImpl} object
     * @return
     */
    private MimeMessage configureMailMessage(final PlatformUserDto platformUserDto, final ConfirmationTokenDto confirmationTokenDto, final JavaMailSenderImpl mailSender) {
        final MimeMessage mailMessage = mailSender.createMimeMessage();
        final MimeMessageHelper helper = new MimeMessageHelper(mailMessage, "utf-8");
        try {
            helper.setFrom(MAIL_SENDER);
            helper.setTo(platformUserDto.getEmail());
            helper.setSubject(CONFIRMATION_SUBJECT);
            helper.setText(parseTemplate(platformUserDto.getUsername(), confirmationTokenDto.getToken()), true);
        } catch (MessagingException e) {
            LOGGER.debug(e.getMessage());
        }
        return mailMessage;
    }

    /**
     * Method for reading and parsing email HTML template.
     * @param username username
     * @param token token
     * @return HTML template
     */
    private String parseTemplate(final String username, final String token) {
        final StringBuilder contentBuilder = new StringBuilder();
        try {
            final BufferedReader in = new BufferedReader(new FileReader(CONFIRMATION_TEMPLATE));
            String str;
            while ((str = in.readLine()) != null) {
                contentBuilder.append(str);
            }
            in.close();
        } catch (IOException e) {
            LOGGER.debug(e.getMessage());
        }
        String content = contentBuilder.toString();

        content = content.replace(USERNAME_PLACEHOLDER, username).replace(TOKEN_PLACEHOLDER, token);

        return content;
    }
}
