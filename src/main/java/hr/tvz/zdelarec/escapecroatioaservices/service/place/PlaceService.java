package hr.tvz.zdelarec.escapecroatioaservices.service.place;

import hr.tvz.zdelarec.escapecroatioaservices.entity.Place;

import java.util.List;
import java.util.Optional;

/**
 * Place service
 *
 * @author kristijan.zdelarec
 */
public interface PlaceService {

    /**
     * Method for fetching {@link List} of {@link Place} objects.
     * @return {@link List} of {@link Place} objects
     */
    List<Place> getAllPlaces();

    /**
     * Method for fetching one {@link Place} by id.
     * @param id {@link Place} id
     * @return {@link Place} object
     */
    Optional<Place> getPlaceById(Integer id);
}
