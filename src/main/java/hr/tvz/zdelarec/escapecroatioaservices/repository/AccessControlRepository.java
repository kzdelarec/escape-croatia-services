package hr.tvz.zdelarec.escapecroatioaservices.repository;

import hr.tvz.zdelarec.escapecroatioaservices.entity.AccessControl;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Access control repository.
 *
 * @author kristijan.zdelarec
 */
public interface AccessControlRepository extends CrudRepository<AccessControl, Integer> {

    /**
     * Method for fetching all {@link AccessControl} objects by user.
     *
     * @param userId user identifier
     * @return {@link List} of {@link AccessControl} objects.
     */
    List<AccessControl> findAllByUserId(Integer userId);

    /**
     * Deletes all access control for a certain user.
     * @param userId user identifier
     */
    @Transactional
    void deleteByUserId(Integer userId);
}
