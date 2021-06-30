package hr.tvz.zdelarec.escapecroatioaservices.repository;

import hr.tvz.zdelarec.escapecroatioaservices.entity.Place;
import org.springframework.data.repository.CrudRepository;

/**
 * Place repository.
 *
 * @author kristijan.zdelarec
 */
public interface PlaceRepository extends CrudRepository<Place, Integer> {
}
