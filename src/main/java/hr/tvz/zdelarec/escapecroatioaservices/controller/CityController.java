package hr.tvz.zdelarec.escapecroatioaservices.controller;

import hr.tvz.zdelarec.escapecroatioaservices.dto.CityDto;
import hr.tvz.zdelarec.escapecroatioaservices.service.city.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path=CityController.BASE_URL)
@CrossOrigin
public class CityController {
    public static final String BASE_URL = "/city";
    private static final Logger LOGGER =  LoggerFactory.getLogger(CityController.class);

    @Autowired
    private CityService cityService;

    @GetMapping(produces = CityDto.CONTENT_TYPE)
    public List<CityDto> getAll(){
        LOGGER.info("Dohvat");
        return cityService.getAllCities();
    }

    @GetMapping(path="/{id}", produces = CityDto.CONTENT_TYPE)
    public CityDto getById(@PathVariable("id") final Integer id){
        return cityService.getCityById(id);
    }
}
