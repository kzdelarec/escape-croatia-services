package hr.tvz.zdelarec.escapecroatioaservices.api.controller.v2;

import hr.tvz.zdelarec.escapecroatioaservices.dto.CityDto;
import hr.tvz.zdelarec.escapecroatioaservices.service.v2.city.CityServiceV2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller for City CRUD operations.
 *
 * @author kristijan.zdelarec
 */
@RestController
@RequestMapping(path = CityControllerV2.BASE_URL)
@CrossOrigin
public class CityControllerV2 {

    /**
     * Base URL for City controller.
     */
    public static final String BASE_URL = "/api/v2/city";

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(CityControllerV2.class);

    /**
     * Autowired {@link CityServiceV2}.
     */
    @Autowired
    private CityServiceV2 cityService;

    /**
     * Endpoint for fetching all {@link CityDto} objects.
     * @param userId user identifier
     * @return fetched {@link List} of {@link CityDto} objects
     */
    @GetMapping(produces = CityDto.CONTENT_TYPE)
    public List<CityDto> getAll( @RequestParam(name = "userId") final String userId) {
        LOGGER.info("Fetching all cities...");
        return cityService.getAllCities(userId);
    }

    /**
     * Endpoint for fetching {@link CityDto} object.
     *
     * @param id object identifier
     * @param userId user identifier
     * @return {@link CityDto} object
     */
    @GetMapping(path = "/{id}", produces = CityDto.CONTENT_TYPE)
    public CityDto getById(@PathVariable("id") final Integer id, @RequestParam(name = "userId") final String userId) {
        LOGGER.info("Fetching city with ID: {}", id);
        return cityService.getCityById(id, userId);
    }
}