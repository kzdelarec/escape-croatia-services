package hr.tvz.zdelarec.escapecroatioaservices.repository;

import hr.tvz.zdelarec.escapecroatioaservices.entity.Favorite;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Favorite repository.
 *
 * @author kristijan.zdelarec
 */
public interface FavoriteRepository extends CrudRepository<Favorite, Integer> {

    /**
     * Fetch all {@link Favorite} objects by user identifier.
     * @param userId user identifier
     * @return {@link List} of {@link Favorite} objects
     */
    List<Favorite> findAllByUserId(String userId);

    /**
     * Fetch one {@link Favorite} object by user and place identifier.
     * @param userId user identifier
     * @param placeId place identifier
     * @return {@link Favorite} object
     */
    Favorite findOneByUserIdAndPlaceId(String userId, Integer placeId);

}
