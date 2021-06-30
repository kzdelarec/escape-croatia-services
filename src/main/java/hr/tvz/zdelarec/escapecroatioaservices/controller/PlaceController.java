package hr.tvz.zdelarec.escapecroatioaservices.controller;

import hr.tvz.zdelarec.escapecroatioaservices.dto.PlaceDto;
import hr.tvz.zdelarec.escapecroatioaservices.entity.Place;
import hr.tvz.zdelarec.escapecroatioaservices.service.place.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path= PlaceController.BASE_URL)
@CrossOrigin
public class PlaceController {
    public static final String BASE_URL = "/place";

    @Autowired
    private PlaceService placeService;

    @GetMapping(produces = PlaceDto.CONTENT_TYPE)
    public List<Place> getAll(){
        return placeService.getAllPlaces();
    }

    @GetMapping(path="/{id}", produces = PlaceDto.CONTENT_TYPE)
    public Place getById(@PathVariable("id") final Integer id){
        return placeService.getPlaceById(id).orElseThrow();
    }
}
