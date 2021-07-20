package hr.tvz.zdelarec.escapecroatioaservices.service.favorite;

import hr.tvz.zdelarec.escapecroatioaservices.dto.FavoriteDto;
import hr.tvz.zdelarec.escapecroatioaservices.entity.Favorite;
import hr.tvz.zdelarec.escapecroatioaservices.repository.FavoriteRepository;
import hr.tvz.zdelarec.escapecroatioaservices.repository.PlaceRepository;
import hr.tvz.zdelarec.escapecroatioaservices.service.place.PlaceService;
import org.modelmapper.ModelMapper;
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
        return favoriteList.stream().map(favorite -> modelMapper.map(favorite, FavoriteDto.class)).collect(Collectors.toList());
    }

    @Override
    public FavoriteDto getOneFavorite(final FavoriteDto favoriteDto) {
        final Favorite favorite = favoriteRepository.findOneByUserIdAndPlaceId(favoriteDto.getUserId(), favoriteDto.getPlaceId());
        return modelMapper.map(favorite, FavoriteDto.class);
    }

    @Override
    public FavoriteDto createFavorite(final FavoriteDto favoriteDto) {
        if (existsByUserIdAndPlaceId(favoriteDto)) {
            return favoriteDto;
        } else {
            final Favorite favorite = favoriteRepository.save(modelMapper.map(favoriteDto, Favorite.class));
            return modelMapper.map(favorite, FavoriteDto.class);
        }
    }

    @Override
    public void deleteFavorite(final FavoriteDto favoriteDto) {
        if (existsByUserIdAndPlaceId(favoriteDto)) {
            final Favorite favorite = favoriteRepository.findOneByUserIdAndPlaceId(favoriteDto.getUserId(), favoriteDto.getPlaceId());
            if (favorite != null) {
                favoriteRepository.delete(favorite);
            }
        }
    }

    @Override
    public Boolean existsByUserIdAndPlaceId(final FavoriteDto favoriteDto) {
        return favoriteRepository.existsByUserIdAndPlaceId(favoriteDto.getUserId(), favoriteDto.getPlaceId());
    }
}
