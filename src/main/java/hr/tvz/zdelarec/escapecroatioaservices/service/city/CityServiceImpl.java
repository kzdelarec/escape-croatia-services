package hr.tvz.zdelarec.escapecroatioaservices.service.city;

import hr.tvz.zdelarec.escapecroatioaservices.mapper.impl.CityMapper;
import hr.tvz.zdelarec.escapecroatioaservices.dto.CityDto;
import hr.tvz.zdelarec.escapecroatioaservices.entity.City;
import hr.tvz.zdelarec.escapecroatioaservices.repository.CityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private ModelMapper modelMapper;

    private CityMapper cityMapper;

    @Override
    public List<CityDto> getAllCities() {
        cityMapper = new CityMapper(modelMapper);
        final List<City> cityList = (List<City>) cityRepository.findAll();
        return cityList.stream().map(city -> cityMapper.mapToDto(city)).collect(Collectors.toList());
    }

    @Override
    public CityDto getCityById(final Integer id) {
        cityMapper = new CityMapper(modelMapper);
        final City city= cityRepository.findById(id).orElseThrow();
        return cityMapper.mapToDto(city);
    }
}
