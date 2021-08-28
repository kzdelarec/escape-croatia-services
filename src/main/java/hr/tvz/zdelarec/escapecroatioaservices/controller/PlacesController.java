package hr.tvz.zdelarec.escapecroatioaservices.controller;

import hr.tvz.zdelarec.escapecroatioaservices.dto.CityDto;
import hr.tvz.zdelarec.escapecroatioaservices.dto.PlaceDto;
import hr.tvz.zdelarec.escapecroatioaservices.service.city.CityService;
import hr.tvz.zdelarec.escapecroatioaservices.service.place.PlaceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Contains mappings related to the places page.
 *
 * @author kristijan.zdelarec
 */
@Controller
@RequestMapping(value = {"/places"})
public class PlacesController {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PlacesController.class);

    /**
     * Autowired {@link CityService}.
     */
    @Autowired
    private CityService cityService;

    /**
     * Autowired {@link PlaceService}.
     */
    @Autowired
    private PlaceService placeService;

    /**
     * Get places view page.
     *
     * @param model view model
     * @return view name
     */
    @GetMapping
    public String showPlaces(final Model model) {
        LOGGER.debug("Showing places page");
        final Map<Integer, CityDto> cityMap = cityService.getAllCities().stream().collect(Collectors.toMap(CityDto::getId, Function.identity()));
        final List<PlaceDto> placeDtoList = placeService.getAllPlaces();
        model.addAttribute("places", placeDtoList);
        model.addAttribute("cities", cityMap);
        return "places";
    }

    /**
     * Get places view page by city identifier.
     * @param id {@link CityDto} identifier
     * @param model view model
     * @return view name
     */
    @GetMapping(path = "/{id}")
    public String showPlacesByCityId(final Model model, @PathVariable("id") final Integer id) {
        LOGGER.debug("Showing places page");
        final Map<Integer, CityDto> cityMap = cityService.getAllCities().stream().collect(Collectors.toMap(CityDto::getId, Function.identity()));
        final List<PlaceDto> placeDtoList = placeService.getAllPlacesByCityId(id);
        model.addAttribute("places", placeDtoList);
        model.addAttribute("cities", cityMap);
        return "places";
    }

    /**
     * Show page for creating a new place.
     * @param model view model
     * @return view name
     */
    @GetMapping(path = "/new")
    public String newPlace(final Model model) {
        model.addAttribute("placeDto", new PlaceDto());
        model.addAttribute("cities", cityService.getAllCities());
        return "newPlace";
    }

    /**
     * Redirect for saving and displaying places page.
     * @param placeDto {@link PlaceDto} object
     * @param model view model
     * @return view name
     */
    @PostMapping(path = "/save")
    public String savePlace(@Validated final PlaceDto placeDto, final Model model) {
        placeService.save(placeDto);
        return "redirect:/places";
    }

    /**
     * Show page for editing a new place.
     * @param model view model
     * @param id {@link PlaceDto} identifier
     * @return view name
     */
    @GetMapping(path = "/edit/{id}")
    public String editPlace(final Model model, @PathVariable("id") final Integer id) {
        model.addAttribute(placeService.getPlaceById(id));
        model.addAttribute("cities", cityService.getAllCities());
        return "newPlace";
    }

    /**
     * Redirect for deleting and displaying places page.
     * @param id {@link PlaceDto} identifier
     * @param model view model
     * @return view name
     */
    @GetMapping(path = "/delete/{id}")
    public String deletePlace(final Model model, @PathVariable("id") final Integer id) {
        placeService.delete(placeService.getPlaceById(id));
        return "redirect:/places";
    }
}
