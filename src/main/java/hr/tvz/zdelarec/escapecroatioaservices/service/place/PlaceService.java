package hr.tvz.zdelarec.escapecroatioaservices.service.place;

import hr.tvz.zdelarec.escapecroatioaservices.dto.PlaceDto;
import hr.tvz.zdelarec.escapecroatioaservices.entity.Place;

import java.util.List;

/**
 * Place service.
 *
 * @author kristijan.zdelarec
 */
public interface PlaceService {

    /**
     * Method for fetching {@link List} of {@link PlaceDto} objects.
     * @param userId user identifier
     * @return {@link List} of {@link PlaceDto} objects
     */
    List<PlaceDto> getAllPlaces(String userId);

    /**
     * Method for fetching {@link List} of {@link PlaceDto} objects.
     * @return {@link List} of {@link PlaceDto} objects
     */
    List<PlaceDto> getAllPlaces();

    /**
     * Method for fetching {@link List} of {@link PlaceDto} objects.
     * @return {@link List} of {@link PlaceDto} objects
     */
    List<PlaceDto> getPlacesByAuthority();

    /**
     * Method for fetching {@link List} of {@link PlaceDto} objects.
     *
     * @param placeIds {@link PlaceDto} identifiers
     * @return {@link List} of {@link PlaceDto} objects
     */
    List<PlaceDto> getAllPlaces(List<Integer> placeIds);

    /**
     * Method for fetching one {@link PlaceDto} by id.
     * @param id {@link PlaceDto} id
     * @param userId user identifier
     * @return {@link PlaceDto} object
     */
    PlaceDto getPlaceById(Integer id, String userId);

    /**
     * Method for fetching one {@link PlaceDto} by id.
     * @param id {@link PlaceDto} id
     * @return {@link PlaceDto} object
     */
    PlaceDto getPlaceById(Integer id);

    /**
     * Method for fetching {@link List} of {@link PlaceDto} objects by city and user identifier.
     * @param id City identifier
     * @param userId user identifier
     * @return {@link List} of {@link PlaceDto} objects
     */
    List<PlaceDto> getAllPlacesByCityId(Integer id, String userId);

    /**
     * Method for fetching {@link List} of {@link PlaceDto} objects by city and user identifier.
     * @param id City identifier
     * @return {@link List} of {@link PlaceDto} objects
     */
    List<PlaceDto> getAllPlacesByCityId(Integer id);

    /**
     * Find all user's favourite places.
     * @param userId user identifier
     * @return {@link List} of {@link Place} objects
     */
    List<PlaceDto> getAllByIdIn(String userId);

    /**
     * Method for saving new or updated {@link PlaceDto} object.
     * @param placeDto {@link PlaceDto} object
     * @return saved {@link PlaceDto} object
     */
    PlaceDto save(PlaceDto placeDto);

    /**
     * Method for deleting a {@link PlaceDto} object.
     * @param placeDto {@link PlaceDto} object
     */
    void delete(PlaceDto placeDto);
}
