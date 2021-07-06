package hr.tvz.zdelarec.escapecroatioaservices.mapper.impl;

import hr.tvz.zdelarec.escapecroatioaservices.dto.CityDto;
import hr.tvz.zdelarec.escapecroatioaservices.entity.City;
import hr.tvz.zdelarec.escapecroatioaservices.mapper.BasicMapper;
import org.modelmapper.ModelMapper;

/**
 * Mapping implementation for {@link City} entity and {@link CityDto}.
 *
 * @author kristijan.zdelarec
 */
public class CityMapper implements BasicMapper<CityDto, City> {

    /**
     * Autowired {@link ModelMapper}.
     */
    private ModelMapper modelMapper;

    /**
     * Primary constructor.
     * @param modelMapper {@link ModelMapper} object
     */
    public CityMapper(final ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public CityDto mapToDto(final City city) {
        final CityDto cityDto = modelMapper.map(city, CityDto.class);
        cityDto.setProgress(0);
        cityDto.setNumberOfRooms(0);
        return cityDto;
    }

    @Override
    public City mapToEntity(final CityDto cityDto) {
        return modelMapper.map(cityDto, City.class);
    }
}
