package hr.tvz.zdelarec.escapecroatioaservices.service.city;

import hr.tvz.zdelarec.escapecroatioaservices.dto.CityDto;

import java.util.List;

/**
 * City service.
 *
 * @author kristijan.zdelarec
 */
public interface CityService {

    /**
     * Method for fetching {@link List} of {@link CityDto} objects.
     * @return {@link List} of {@link CityDto} objects
     */
    List<CityDto> getAllCities();

    /**
     * Method for fetching one {@link CityDto} by id.
     * @param id {@link CityDto} id
     * @return {@link CityDto} object
     */
    CityDto getCityById(Integer id);
}
