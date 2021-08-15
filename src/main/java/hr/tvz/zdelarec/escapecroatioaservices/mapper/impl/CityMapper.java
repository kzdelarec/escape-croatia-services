package hr.tvz.zdelarec.escapecroatioaservices.mapper.impl;

import hr.tvz.zdelarec.escapecroatioaservices.dto.CityDto;
import hr.tvz.zdelarec.escapecroatioaservices.entity.City;
import hr.tvz.zdelarec.escapecroatioaservices.mapper.BasicMapper;
import hr.tvz.zdelarec.escapecroatioaservices.service.progress.ProgressService;
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
    private ProgressService progressService;
    private String userId;

    /**
     * Primary constructor.
     * @param modelMapper {@link ModelMapper} object
     * @param progressService {@link ProgressService} object
     * @param userId user identifier
     */
    public CityMapper(final ModelMapper modelMapper, final ProgressService progressService, final String userId) {
        this.modelMapper = modelMapper;
        this.progressService = progressService;
        this.userId = userId;
    }

    @Override
    public CityDto mapToDto(final City city) {
        final CityDto cityDto = modelMapper.map(city, CityDto.class);
        cityDto.setProgress(progressService.getProgressByCityId(city.getId(), userId));
        return cityDto;
    }

    @Override
    public City mapToEntity(final CityDto cityDto) {
        return modelMapper.map(cityDto, City.class);
    }
}
