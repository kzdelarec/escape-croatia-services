package hr.tvz.zdelarec.escapecroatioaservices.repository;

import hr.tvz.zdelarec.escapecroatioaservices.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * User repository.
 *
 * @author kristijan.zdelarec
 */
public interface UserRepository extends CrudRepository<User, String> {

    /**
     * Check if user Id exists.
     * @param userId user identifier
     * @return {@link Boolean}
     */
    Boolean existsByUserId(String userId);

}
