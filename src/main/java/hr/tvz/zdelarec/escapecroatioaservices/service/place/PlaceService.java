package hr.tvz.zdelarec.escapecroatioaservices.service.place;

import hr.tvz.zdelarec.escapecroatioaservices.dto.PlaceDto;

import java.util.List;

/**
 * Place service.
 *
 * @author kristijan.zdelarec
 */
public interface PlaceService {

    /**
     * Method for fetching {@link List} of {@link PlaceDto} objects.
     * @return {@link List} of {@link PlaceDto} objects
     */
    List<PlaceDto> getAllPlaces();

    /**
     * Method for fetching one {@link PlaceDto} by id.
     * @param id {@link PlaceDto} id
     * @return {@link PlaceDto} object
     */
    PlaceDto getPlaceById(Integer id);

    /**
     * Method for fetching {@link List} of {@link PlaceDto} objects by city identifier.
     * @param id City identifier
     * @return {@link List} of {@link PlaceDto} objects
     */
    List<PlaceDto> getAllPlacesByCityId(Integer id);
}
