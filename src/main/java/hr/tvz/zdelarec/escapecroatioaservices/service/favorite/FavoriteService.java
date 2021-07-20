package hr.tvz.zdelarec.escapecroatioaservices.service.favorite;

import hr.tvz.zdelarec.escapecroatioaservices.dto.FavoriteDto;
import hr.tvz.zdelarec.escapecroatioaservices.entity.Favorite;

import java.util.List;

/**
 * Favorite service.
 *
 * @author kristijan.zdelarec
 */
public interface FavoriteService {

    /**
     * Method for fetching {@link List} of {@link Favorite} objects by user identifier.
     * @param userId usr identifier
     * @return {@link List} of {@link FavoriteDto} objects
     */
    List<FavoriteDto> getAllFavorites(String userId);

    /**
     * Method for fetching one {@link FavoriteDto} object.
     * @param favoriteDto {@link FavoriteDto} object
     * @return {@link FavoriteDto} object
     */
    FavoriteDto getOneFavorite(FavoriteDto favoriteDto);

    /**
     * Method for creating new {@link FavoriteDto} object.
     * @param favoriteDto {@link FavoriteDto} object
     * @return saved {@link FavoriteDto} object
     */
    FavoriteDto createFavorite(FavoriteDto favoriteDto);

    /**
     * Method for deleting existing {@link FavoriteDto} object.
     * @param favoriteDto {@link FavoriteDto} object
     */
    void deleteFavorite(FavoriteDto favoriteDto);

    /**
     * Check if {@link Favorite} exists.
     * @param favoriteDto {@link FavoriteDto} object
     * @return {@link Boolean}
     */
    Boolean existsByUserIdAndPlaceId(FavoriteDto favoriteDto);
}
