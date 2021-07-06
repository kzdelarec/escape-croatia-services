package hr.tvz.zdelarec.escapecroatioaservices.service.place;

import hr.tvz.zdelarec.escapecroatioaservices.dto.PlaceDto;
import hr.tvz.zdelarec.escapecroatioaservices.entity.Place;
import hr.tvz.zdelarec.escapecroatioaservices.mapper.impl.PlaceMapper;
import hr.tvz.zdelarec.escapecroatioaservices.repository.PlaceRepository;
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
public class PlaceServiceImpl implements PlaceService {

    /**
     * Autowired {@link PlaceRepository}.
     *
     */
    @Autowired
    private PlaceRepository placeRepository;

    /**
     * Autowired {@link ModelMapper}.
     */
    @Autowired
    private ModelMapper modelMapper;

    private PlaceMapper placeMapper;

    @Override
    public List<PlaceDto> getAllPlaces() {
        placeMapper = new PlaceMapper(modelMapper);
        final List<Place> placeList = (List<Place>) placeRepository.findAll();
        return placeList.stream().map(place -> placeMapper.mapToDto(place)).collect(Collectors.toList());
    }

    @Override
    public PlaceDto getPlaceById(final Integer id) {
        placeMapper = new PlaceMapper(modelMapper);
        final Place place = placeRepository.findById(id).orElseThrow();
        return placeMapper.mapToDto(place);
    }
}
