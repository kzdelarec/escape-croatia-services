package hr.tvz.zdelarec.escapecroatioaservices.mapper.impl;

import hr.tvz.zdelarec.escapecroatioaservices.dto.FavoriteDto;
import hr.tvz.zdelarec.escapecroatioaservices.dto.PlaceDto;
import hr.tvz.zdelarec.escapecroatioaservices.entity.Place;
import hr.tvz.zdelarec.escapecroatioaservices.mapper.BasicMapper;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Objects;

/**
 * Mapping implementation for {@link Place} entity and {@link PlaceDto}.
 *
 * @author kristijan.zdelarec
 */
public class PlaceMapper implements BasicMapper<PlaceDto, Place> {

    private ModelMapper modelMapper;
    private List<FavoriteDto> favoriteDtoList;

    /**
     * Primary constructor.
     * @param modelMapper {@link ModelMapper} object
     * @param favoriteDtoList {@link List} of {@link FavoriteDto} objects related to the {@link Place} and user
     */
    public PlaceMapper(final ModelMapper modelMapper, final List<FavoriteDto> favoriteDtoList) {
        this.modelMapper = modelMapper;
        this.favoriteDtoList = favoriteDtoList;
    }

    @Override
    public PlaceDto mapToDto(final Place place) {
        final PlaceDto placeDto =  modelMapper.map(place, PlaceDto.class);
        placeDto.setFavorite(favoriteDtoList.stream().anyMatch(favoriteDto -> Objects.equals(favoriteDto.getPlaceId(), placeDto.getId())));
        return placeDto;
    }

    @Override
    public Place mapToEntity(final PlaceDto placeDto) {
        return modelMapper.map(placeDto, Place.class);
    }
}
