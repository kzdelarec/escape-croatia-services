package hr.tvz.zdelarec.escapecroatioaservices.controller;

import hr.tvz.zdelarec.escapecroatioaservices.dto.PlaceDto;
import hr.tvz.zdelarec.escapecroatioaservices.service.place.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
     * Autowired {@link PlaceService}.
     */
    @Autowired
    private PlaceService placeService;

    /**
     * Endpoint for fetching all {@link PlaceDto} objects.
     *
     * @return fetched {@link List} of {@link PlaceDto} objects
     */
    @GetMapping(produces = PlaceDto.CONTENT_TYPE)
    public List<PlaceDto> getAll() {
        return placeService.getAllPlaces();
    }

    /**
     * Endpoint for fetching {@link PlaceDto} object.
     *
     * @param id object identifier
     * @return {@link PlaceDto} object
     */
    @GetMapping(path = "/{id}", produces = PlaceDto.CONTENT_TYPE)
    public PlaceDto getById(@PathVariable("id") final Integer id) {
        return placeService.getPlaceById(id);
    }

    /**
     * Endpoint for fetching all {@link PlaceDto} objects by City identifier.
     *
     * @param id City identifier
     * @return {@link PlaceDto} object
     */
    @GetMapping(path = "/city/{id}", produces = PlaceDto.CONTENT_TYPE)
    public List<PlaceDto> getByCityId(@PathVariable("id") final Integer id) {
        return placeService.getAllPlacesByCityId(id);
    }
}
