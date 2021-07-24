package hr.tvz.zdelarec.escapecroatioaservices.service.favorite;

import hr.tvz.zdelarec.escapecroatioaservices.dto.FavoriteDto;
import hr.tvz.zdelarec.escapecroatioaservices.entity.Favorite;
import hr.tvz.zdelarec.escapecroatioaservices.repository.FavoriteRepository;
import hr.tvz.zdelarec.escapecroatioaservices.repository.PlaceRepository;
import hr.tvz.zdelarec.escapecroatioaservices.service.place.PlaceService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * {@link PlaceService} implementation.
 *
 * @author kristijan.zdelarec
 */
@Service
public class FavoriteServiceImpl implements FavoriteService {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(FavoriteService.class);

    /**
     * Autowired {@link PlaceRepository}.
     *
     */
    @Autowired
    private FavoriteRepository favoriteRepository;

    /**
     * Autowired {@link ModelMapper}.
     */
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<FavoriteDto> getAllFavorites(final String userId) {
        final List<Favorite> favoriteList = favoriteRepository.findAllByUserId(userId);
        LOGGER.info("Found {} results for user {}", favoriteList.size(), userId);
        return favoriteList.stream().map(favorite -> modelMapper.map(favorite, FavoriteDto.class)).collect(Collectors.toList());
    }

    @Override
    public FavoriteDto getOneFavorite(final FavoriteDto favoriteDto) {
        final Favorite favorite = favoriteRepository.findOneByUserIdAndPlaceId(favoriteDto.getUserId(), favoriteDto.getPlaceId());
        LOGGER.info("Found {}  for user {}", favorite, favoriteDto.getUserId());
        return modelMapper.map(favorite, FavoriteDto.class);
    }

    @Override
    public FavoriteDto createFavorite(final FavoriteDto favoriteDto) {
        if (existsByUserIdAndPlaceId(favoriteDto)) {
            LOGGER.info("Favourite with place ID {}  for user {} already exists.", favoriteDto.getPlaceId(), favoriteDto.getUserId());
            return favoriteDto;
        } else {
            final Favorite favorite = favoriteRepository.save(modelMapper.map(favoriteDto, Favorite.class));
            LOGGER.info("Created favourite with place ID {}  for user {}.", favoriteDto.getPlaceId(), favoriteDto.getUserId());
            return modelMapper.map(favorite, FavoriteDto.class);
        }
    }

    @Override
    public void deleteFavorite(final FavoriteDto favoriteDto) {
        if (existsByUserIdAndPlaceId(favoriteDto)) {
            final Favorite favorite = favoriteRepository.findOneByUserIdAndPlaceId(favoriteDto.getUserId(), favoriteDto.getPlaceId());
            if (favorite != null) {
                favoriteRepository.delete(favorite);
                LOGGER.info("Removed favourite with place ID {}  for user {}.", favoriteDto.getPlaceId(), favoriteDto.getUserId());
            }
        } else {
            LOGGER.info("Favourite with place ID {}  for user {} does not exist.", favoriteDto.getPlaceId(), favoriteDto.getUserId());
        }
    }

    @Override
    public Boolean existsByUserIdAndPlaceId(final FavoriteDto favoriteDto) {
        return favoriteRepository.existsByUserIdAndPlaceId(favoriteDto.getUserId(), favoriteDto.getPlaceId());
    }
}
