package hr.tvz.zdelarec.escapecroatioaservices.service.v2.city;

import hr.tvz.zdelarec.escapecroatioaservices.dto.CityDto;
import hr.tvz.zdelarec.escapecroatioaservices.entity.City;
import hr.tvz.zdelarec.escapecroatioaservices.mapper.impl.CityMapperV2;
import hr.tvz.zdelarec.escapecroatioaservices.repository.CityRepository;
import hr.tvz.zdelarec.escapecroatioaservices.service.v2.progress.ProgressServiceV2;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 *  {@link CityServiceV2} implementation.
 *
 * @author kristijan.zdelarec
 */
@Service
public class CityServiceV2Impl implements CityServiceV2 {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(CityServiceV2.class);

    /**
     * Autowired {@link CityRepository}.
     */
    @Autowired
    private CityRepository cityRepository;

    /**
     * Autowired {@link ModelMapper}.
     */
    @Autowired
    private ModelMapper modelMapper;

    /**
     * Autowired {@link ProgressServiceV2}.
     */
    @Autowired
    private ProgressServiceV2 progressService;

    private CityMapperV2 cityMapper;

    @Override
    public List<CityDto> getAllCities(final String userId) {
        cityMapper = new CityMapperV2(modelMapper, progressService, userId);
        final List<City> cityList = (List<City>) cityRepository.findAll();
        LOGGER.info("Found {} results", cityList.size());
        return cityList.stream().map(city -> cityMapper.mapToDto(city)).collect(Collectors.toList());
    }

    @Override
    public List<CityDto> getAllCities() {
        final List<City> cityList = (List<City>) cityRepository.findAll();
        LOGGER.info("Found {} results", cityList.size());
        return cityList.stream().map(city -> modelMapper.map(city, CityDto.class)).collect(Collectors.toList());
    }

    @Override
    public CityDto getCityById(final Integer id, final String userId) {
        cityMapper = new CityMapperV2(modelMapper, progressService, userId);
        final City city = cityRepository.findById(id).orElseThrow();
        LOGGER.info("Fetched city: {}", city);
        return cityMapper.mapToDto(city);
    }

    @Override
    public CityDto getCityById(final Integer id) {
        final City city = cityRepository.findById(id).orElseThrow();
        LOGGER.info("Fetched city: {}", city);
        return modelMapper.map(city, CityDto.class);
    }

    @Override
    public CityDto save(final CityDto cityDto) {
        return modelMapper.map(cityRepository.save(modelMapper.map(cityDto, City.class)), CityDto.class);
    }

    @Override
    public void delete(final CityDto cityDto) {
       cityRepository.delete(modelMapper.map(cityDto, City.class));
    }


}
