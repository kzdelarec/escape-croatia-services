package hr.tvz.zdelarec.escapecroatioaservices.repository;

import hr.tvz.zdelarec.escapecroatioaservices.entity.Place;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Place repository.
 *
 * @author kristijan.zdelarec
 */
public interface PlaceRepository extends CrudRepository<Place, Integer> {

    /**
     * Find all places by city identifier.
     * @param id city identifier
     * @return {@link List} of {@link Place} objects
     */
    List<Place> findAllByCityId(Integer id);
}
