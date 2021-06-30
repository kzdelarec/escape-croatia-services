package hr.tvz.zdelarec.escapecroatioaservices.service.room;

import hr.tvz.zdelarec.escapecroatioaservices.entity.Room;
import hr.tvz.zdelarec.escapecroatioaservices.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public List<Room> getAllRooms() {
        return (List<Room>) roomRepository.findAll();
    }

    @Override
    public Optional<Room> getRoomById(final Integer id) {
        return roomRepository.findById(id);
    }
}
