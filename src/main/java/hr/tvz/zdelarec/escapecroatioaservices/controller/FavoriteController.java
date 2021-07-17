package hr.tvz.zdelarec.escapecroatioaservices.controller;

import hr.tvz.zdelarec.escapecroatioaservices.dto.FavoriteDto;
import hr.tvz.zdelarec.escapecroatioaservices.service.favorite.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Controller for Favorite CRUD operations.
 *
 * @author kristijan.zdelarec
 */
@RestController
@RequestMapping(path = FavoriteController.BASE_URL)
@CrossOrigin
public class FavoriteController {
    /**
     * Base URL for Favorite controller.
     */
    public static final String BASE_URL = "/favorite";

    /**
     * Autowired {@link FavoriteService}.
     */
    @Autowired
    private FavoriteService favoriteService;


    @PostMapping(consumes = FavoriteDto.CONTENT_TYPE, produces = FavoriteDto.CONTENT_TYPE)
    public FavoriteDto createFavorite(@RequestBody @Valid final FavoriteDto favoriteDto) {
        return favoriteService.createFavorite(favoriteDto);
    }

    @DeleteMapping(consumes = FavoriteDto.CONTENT_TYPE)
    public void removeFavourite(@RequestBody @Valid final FavoriteDto favoriteDto) {
        favoriteService.deleteFavorite(favoriteDto);
    }
}
