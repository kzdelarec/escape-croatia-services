package hr.tvz.zdelarec.escapecroatioaservices.controller;

import hr.tvz.zdelarec.escapecroatioaservices.dto.CityDto;
import hr.tvz.zdelarec.escapecroatioaservices.entity.City;
import hr.tvz.zdelarec.escapecroatioaservices.service.city.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path=CityController.BASE_URL)
@CrossOrigin
public class CityController {
    public static final String BASE_URL = "/city";

    @Autowired
    private CityService cityService;

    @GetMapping(produces = CityDto.CONTENT_TYPE)
    public List<City> getAll(){
        return cityService.getAllCities();
    }

    @GetMapping(path="/{id}", produces = CityDto.CONTENT_TYPE)
    public City getById(@PathVariable("id") final Integer id){
        return cityService.getCityById(id).orElseThrow();
    }
}
