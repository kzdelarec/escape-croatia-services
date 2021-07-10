package hr.tvz.zdelarec.escapecroatioaservices.mapper.impl;

import hr.tvz.zdelarec.escapecroatioaservices.dto.PlaceDto;
import hr.tvz.zdelarec.escapecroatioaservices.entity.Place;
import hr.tvz.zdelarec.escapecroatioaservices.mapper.BasicMapper;
import org.modelmapper.ModelMapper;

/**
 * Mapping implementation for {@link Place} entity and {@link PlaceDto}.
 *
 * @author kristijan.zdelarec
 */
public class PlaceMapper implements BasicMapper<PlaceDto, Place> {

    /**
     * Autowired {@link ModelMapper}.
     */
    private ModelMapper modelMapper;

    /**
     * Primary constructor.
     * @param modelMapper {@link ModelMapper} object
     */
    public PlaceMapper(final ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public PlaceDto mapToDto(final Place place) {
        final PlaceDto placeDto =  modelMapper.map(place, PlaceDto.class);
        placeDto.setFavorite(false);
        return placeDto;
    }

    @Override
    public Place mapToEntity(final PlaceDto placeDto) {
        return modelMapper.map(placeDto, Place.class);
    }
}
