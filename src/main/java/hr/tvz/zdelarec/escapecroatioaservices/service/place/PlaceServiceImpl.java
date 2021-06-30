package hr.tvz.zdelarec.escapecroatioaservices.service.place;

import hr.tvz.zdelarec.escapecroatioaservices.entity.Place;
import hr.tvz.zdelarec.escapecroatioaservices.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaceServiceImpl implements PlaceService {

    @Autowired
    private PlaceRepository placeRepository;

    @Override
    public List<Place> getAllPlaces() {
        return (List<Place>) placeRepository.findAll();
    }

    @Override
    public Optional<Place> getPlaceById(final Integer id) {
        return placeRepository.findById(id);
    }
}
