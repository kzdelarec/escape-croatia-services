package hr.tvz.zdelarec.escapecroatioaservices.service.confirmationTokenService;

import hr.tvz.zdelarec.escapecroatioaservices.dto.ConfirmationTokenDto;

/**
 * Confirmation Token service.
 *
 * @author kristijan.zdelarec
 */
public interface ConfirmationTokenService {

    /**
     * Method for getting a {@link ConfirmationTokenDto} by token.
     * @param token token
     * @return {@link ConfirmationTokenDto} object
     */
    ConfirmationTokenDto getByToken(String token);

    /**
     * Method for deleting by token.
     * @param token token
     */
    void deleteByToken(String token);

    /**
     * Method for saving a {@link ConfirmationTokenDto} object.
     * @param confirmationTokenDto {@link ConfirmationTokenDto} object to be saved
     * @return saved {@link ConfirmationTokenDto} object
     */
    ConfirmationTokenDto save(ConfirmationTokenDto confirmationTokenDto);


}
