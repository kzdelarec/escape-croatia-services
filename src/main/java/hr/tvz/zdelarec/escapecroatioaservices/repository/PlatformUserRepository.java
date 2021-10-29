package hr.tvz.zdelarec.escapecroatioaservices.repository;

import hr.tvz.zdelarec.escapecroatioaservices.entity.PlatformUser;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Platform User repository.
 *
 * @author kristijan.zdelarec
 */
public interface PlatformUserRepository extends CrudRepository<PlatformUser, Long> {

    /**
     * Method for getting all {@link PlatformUser} objects.
     * @return {@link List} of {@link PlatformUser} objects.
     */
    List<PlatformUser> findAll();
}
