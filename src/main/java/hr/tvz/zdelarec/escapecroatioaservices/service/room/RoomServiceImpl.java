package hr.tvz.zdelarec.escapecroatioaservices.service.room;

import hr.tvz.zdelarec.escapecroatioaservices.dto.RoomDto;
import hr.tvz.zdelarec.escapecroatioaservices.entity.Room;
import hr.tvz.zdelarec.escapecroatioaservices.mapper.impl.RoomMapper;
import hr.tvz.zdelarec.escapecroatioaservices.repository.RoomRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * {@link RoomService} implementation.
 *
 * @author kristijan.zdelarec
 */
@Service
public class RoomServiceImpl implements RoomService {

    /**
     * Autowired {@link RoomRepository}.
     */
    @Autowired
    private RoomRepository roomRepository;

    /**
     * Autowired {@link ModelMapper}.
     */
    @Autowired
    private ModelMapper modelMapper;

    private RoomMapper roomMapper;

    @Override
    public List<RoomDto> getAllRooms() {
        roomMapper = new RoomMapper(modelMapper);
        final List<Room> roomList = (List<Room>) roomRepository.findAll();
        return roomList.stream().map(room -> roomMapper.mapToDto(room)).collect(Collectors.toList());
    }

    @Override
    public RoomDto getRoomById(final Integer id) {
        roomMapper = new RoomMapper(modelMapper);
        final Room room = roomRepository.findById(id).orElseThrow();
        return roomMapper.mapToDto(room);
    }

    @Override
    public List<RoomDto> getAllRoomsByPlaceId(final Integer id) {
        roomMapper = new RoomMapper(modelMapper);
        final List<Room> roomList = roomRepository.findAllByPlaceId(id);
        return roomList.stream().map(room -> roomMapper.mapToDto(room)).collect(Collectors.toList());
    }
}
