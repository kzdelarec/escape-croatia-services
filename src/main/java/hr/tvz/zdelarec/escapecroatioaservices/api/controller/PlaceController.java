package hr.tvz.zdelarec.escapecroatioaservices.api.controller;

import hr.tvz.zdelarec.escapecroatioaservices.dto.PlaceDto;
import hr.tvz.zdelarec.escapecroatioaservices.service.place.PlaceService;
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
 * Controller for Place CRUD operations.
 *
 * @author kristijan.zdelarec
 */
@RestController
@RequestMapping(path = PlaceController.BASE_URL)
@CrossOrigin
public class PlaceController {
    /**
     * Base URL for Place controller.
     */
    public static final String BASE_URL = "/place";

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PlaceController.class);

    /**
     * Autowired {@link PlaceService}.
     */
    @Autowired
    private PlaceService placeService;

    /**
     * Endpoint for fetching all {@link PlaceDto} objects.
     *
     * @param userId user identifier
     * @return fetched {@link List} of {@link PlaceDto} objects
     */
    @GetMapping(produces = PlaceDto.CONTENT_TYPE)
    public List<PlaceDto> getAll(@RequestParam(name = "userId") final String userId) {
        LOGGER.info("Fetching all places for user {}", userId);
        return placeService.getAllPlaces(userId);
    }

    /**
     * Endpoint for fetching {@link PlaceDto} object.
     *
     * @param id object identifier
     * @param userId user identifier
     * @return {@link PlaceDto} object
     */
    @GetMapping(path = "/{id}", produces = PlaceDto.CONTENT_TYPE)
    public PlaceDto getById(@PathVariable("id") final Integer id, @RequestParam(name = "userId") final String userId) {
        LOGGER.info("Fetching one place with ID {} for user {}", id, userId);
        return placeService.getPlaceById(id, userId);
    }

    /**
     * Endpoint for fetching all {@link PlaceDto} objects by City identifier.
     *
     * @param id City identifier
     * @param userId user identifier
     * @return {@link PlaceDto} object
     */
    @GetMapping(path = "/city/{id}", produces = PlaceDto.CONTENT_TYPE)
    public List<PlaceDto> getByCityId(@PathVariable("id") final Integer id, @RequestParam(name = "userId") final String userId) {
        LOGGER.info("Fetching all places by city ID {} for user {}", id, userId);
        return placeService.getAllPlacesByCityId(id, userId);
    }

    /**
     * Endpoint for fetching all user's favourite {@link PlaceDto} objects.
     *
     * @param userId user identifier
     * @return {@link PlaceDto} object
     */
    @GetMapping(path = "/favorites", produces = PlaceDto.CONTENT_TYPE)
    public List<PlaceDto> getFavourites(@RequestParam(name = "userId") final String userId) {
        LOGGER.info("Fetching favorite places for user {}", userId);
        return placeService.getAllByIdIn(userId);
    }
}
