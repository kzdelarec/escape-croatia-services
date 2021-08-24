package hr.tvz.zdelarec.escapecroatioaservices.controller;

import hr.tvz.zdelarec.escapecroatioaservices.dto.CityDto;
import hr.tvz.zdelarec.escapecroatioaservices.service.city.CityService;
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

/**
 * Contains mappings related to the cities page.
 *
 * @author kristijan.zdelarec
 */
@Controller
@RequestMapping(value = {"/cities"})
public class CitiesController {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(CitiesController.class);

    /**
     * Autowired {@link CityService}.
     */
    @Autowired
    private CityService cityService;

    /**
     * Get cities view page.
     *
     * @param model view model
     * @return view name
     */
    @GetMapping
    public String showCities(final Model model) {
        LOGGER.debug("Showing dashboard page");
        final List<CityDto> cityDtoList = cityService.getAllCities();
        model.addAttribute("cities", cityDtoList);
        return "cities";
    }

    /**
     * Show page for creating a new city.
     * @param model view model
     * @return view name
     */
    @GetMapping(path = "/new")
    public String newCity(final Model model) {
        model.addAttribute(new CityDto());
        return "newCity";
    }

    /**
     * Redirect for saving and displaying cities page.
     * @param cityDto {@link CityDto} object
     * @param model view model
     * @return view name
     */
    @PostMapping(path = "/save")
    public String saveCity(@Validated final CityDto cityDto, final Model model) {
        cityService.save(cityDto);
        return "redirect:/cities";
    }

    /**
     * Show page for editing a new city.
     * @param model view model
     * @param id {@link CityDto} identifier
     * @return view name
     */
    @GetMapping(path = "/edit/{id}")
    public String editCity(final Model model, @PathVariable("id") final Integer id) {
        model.addAttribute(cityService.getCityById(id));
        return "newCity";
    }

    /**
     * Redirect for deleting and displaying cities page.
     * @param id {@link CityDto} identifier
     * @param model view model
     * @return view name
     */
    @GetMapping(path = "/delete/{id}")
    public String deleteCity(final Model model, @PathVariable("id") final Integer id) {
        cityService.delete(cityService.getCityById(id));
        return "redirect:/cities";
    }


}
