package hr.tvz.zdelarec.escapecroatioaservices.repository;

import hr.tvz.zdelarec.escapecroatioaservices.entity.ConfirmationToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Confirmation Token repository.
 *
 * @author kristijan.zdelarec
 */
public interface ConfirmationTokenRepository extends CrudRepository<ConfirmationToken, String> {

    /**
     * Method for finding a {@link ConfirmationToken} object by token.
     *
     * @param token token
     * @return {@link ConfirmationToken} object.
     */
    ConfirmationToken findOneByToken(String token);

    /**
     * Deletes {@link ConfirmationToken} by token.
     * @param token token
     */
    @Transactional
    void deleteOneByToken(String token);

}
