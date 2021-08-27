package hr.tvz.zdelarec.escapecroatioaservices.service.place;

import hr.tvz.zdelarec.escapecroatioaservices.dto.FavoriteDto;
import hr.tvz.zdelarec.escapecroatioaservices.dto.PlaceDto;
import hr.tvz.zdelarec.escapecroatioaservices.entity.Place;
import hr.tvz.zdelarec.escapecroatioaservices.mapper.impl.PlaceMapper;
import hr.tvz.zdelarec.escapecroatioaservices.repository.PlaceRepository;
import hr.tvz.zdelarec.escapecroatioaservices.service.favorite.FavoriteService;
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
public class PlaceServiceImpl implements PlaceService {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PlaceService.class);

    /**
     * Autowired {@link PlaceRepository}.
     *
     */
    @Autowired
    private PlaceRepository placeRepository;

    /**
     * Autowired {@link FavoriteService}.
     */
    @Autowired
    private FavoriteService favoriteService;

    /**
     * Autowired {@link ModelMapper}.
     */
    @Autowired
    private ModelMapper modelMapper;

    private PlaceMapper placeMapper;

    @Override
    public List<PlaceDto> getAllPlaces(final String userId) {
        final List<FavoriteDto> favoriteDtoList = favoriteService.getAllFavorites(userId);
        placeMapper = new PlaceMapper(modelMapper, favoriteDtoList);
        final List<Place> placeList = (List<Place>) placeRepository.findAll();
        LOGGER.info("Found {} results for user {}", placeList.size(), userId);
        return placeList.stream().map(place -> placeMapper.mapToDto(place)).collect(Collectors.toList());
    }

    @Override
    public List<PlaceDto> getAllPlaces() {
        final List<Place> placeList = (List<Place>) placeRepository.findAll();
        LOGGER.info("Found {} results", placeList.size());
        return placeList.stream().map(place -> modelMapper.map(place, PlaceDto.class)).collect(Collectors.toList());
    }

    @Override
    public PlaceDto getPlaceById(final Integer id, final String userId) {
        final List<FavoriteDto> favoriteDtoList = favoriteService.getAllFavorites(userId);
        placeMapper = new PlaceMapper(modelMapper, favoriteDtoList);
        final Place place = placeRepository.findById(id).orElseThrow();
        LOGGER.info("Found {} user {}", place, userId);
        return placeMapper.mapToDto(place);
    }

    @Override
    public PlaceDto getPlaceById(final Integer id) {
        final Place place = placeRepository.findById(id).orElseThrow();
        LOGGER.info("Found {}", place);
        return modelMapper.map(place, PlaceDto.class);
    }

    @Override
    public List<PlaceDto> getAllPlacesByCityId(final Integer id, final String userId) {
        final List<FavoriteDto> favoriteDtoList = favoriteService.getAllFavorites(userId);
        placeMapper = new PlaceMapper(modelMapper, favoriteDtoList);
        final List<Place> placeList = placeRepository.findAllByCityId(id);
        LOGGER.info("Found {} results with place ID {} for user {}", placeList.size(), id, userId);
        return placeList.stream().map(place -> placeMapper.mapToDto(place)).collect(Collectors.toList());
    }

    @Override
    public List<PlaceDto> getAllPlacesByCityId(final Integer id) {
        final List<Place> placeList = placeRepository.findAllByCityId(id);
        LOGGER.info("Found {} results with place ID {}", placeList.size(), id);
        return placeList.stream().map(place -> modelMapper.map(place, PlaceDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<PlaceDto> getAllByIdIn(final String userId) {
        final List<FavoriteDto> favoriteDtoList = favoriteService.getAllFavorites(userId);
        placeMapper = new PlaceMapper(modelMapper, favoriteDtoList);
        final List<Place> placeList = placeRepository.findAllByIdIn(favoriteDtoList.stream().map(FavoriteDto::getPlaceId).collect(Collectors.toList()));
        LOGGER.info("Found {} results for user {}", placeList.size(), userId);
        return placeList.stream().map(place -> placeMapper.mapToDto(place)).collect(Collectors.toList());
    }

    @Override
    public PlaceDto save(final PlaceDto placeDto) {
        return modelMapper.map(placeRepository.save(modelMapper.map(placeDto, Place.class)), PlaceDto.class);
    }

    @Override
    public void delete(final PlaceDto placeDto) {
        placeRepository.delete(modelMapper.map(placeDto, Place.class));
    }
}
