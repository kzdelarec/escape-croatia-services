package hr.tvz.zdelarec.escapecroatioaservices.service.city;

import hr.tvz.zdelarec.escapecroatioaservices.entity.City;

import java.util.List;
import java.util.Optional;

/**
 * City service
 *
 * @author kristijan.zdelarec
 */
public interface CityService {

    /**
     * Method for fetching {@link List} of {@link City} objects.
     * @return {@link List} of {@link City} objects
     */
    List<City> getAllCities();

    /**
     * Method for fetching one {@link City} by id.
     * @param id {@link City} id
     * @return {@link City} object
     */
    Optional<City> getCityById(Integer id);
}
