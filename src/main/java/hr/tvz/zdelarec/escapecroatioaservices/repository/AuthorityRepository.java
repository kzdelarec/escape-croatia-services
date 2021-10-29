package hr.tvz.zdelarec.escapecroatioaservices.repository;

import hr.tvz.zdelarec.escapecroatioaservices.entity.Authority;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Authority repository.
 *
 * @author kristijan.zdelarec
 */
public interface AuthorityRepository extends CrudRepository<Authority, String> {

    /**
     * Method for fetching all authorities by username.
     *
     * @param username username
     * @return {@link List} of {@link Authority} classes.
     */
    List<Authority> findAllDistinctByUsername( String username);

    /**
     * Deletes all authorities for a certain username.
     * @param username username
     */
    @Transactional
    void deleteByUsername(String username);

}
