package hr.tvz.zdelarec.escapecroatioaservices.service.city;

import hr.tvz.zdelarec.escapecroatioaservices.dto.CityDto;
import hr.tvz.zdelarec.escapecroatioaservices.entity.City;
import hr.tvz.zdelarec.escapecroatioaservices.mapper.impl.CityMapper;
import hr.tvz.zdelarec.escapecroatioaservices.repository.CityRepository;
import hr.tvz.zdelarec.escapecroatioaservices.service.progress.ProgressService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 *  {@link CityService} implementation.
 *
 * @author kristijan.zdelarec
 */
@Service
public class CityServiceImpl implements CityService {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(CityService.class);

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
     * Autowired {@link ProgressService}.
     */
    @Autowired
    private ProgressService progressService;

    private CityMapper cityMapper;

    @Override
    public List<CityDto> getAllCities(final String userId) {
        cityMapper = new CityMapper(modelMapper, progressService, userId);
        final List<City> cityList = (List<City>) cityRepository.findAll();
        LOGGER.info("Found {} results", cityList.size());
        return cityList.stream().map(city -> cityMapper.mapToDto(city)).collect(Collectors.toList());
    }

    @Override
    public CityDto getCityById(final Integer id, final String userId) {
        cityMapper = new CityMapper(modelMapper, progressService, userId);
        final City city = cityRepository.findById(id).orElseThrow();
        LOGGER.info("Fetched city: {}", city);
        return cityMapper.mapToDto(city);
    }
}
