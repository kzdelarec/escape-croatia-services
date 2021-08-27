package hr.tvz.zdelarec.escapecroatioaservices.service.room;

import hr.tvz.zdelarec.escapecroatioaservices.dto.FinishedRoomDto;
import hr.tvz.zdelarec.escapecroatioaservices.dto.RoomDto;
import hr.tvz.zdelarec.escapecroatioaservices.entity.Room;
import hr.tvz.zdelarec.escapecroatioaservices.mapper.impl.RoomMapper;
import hr.tvz.zdelarec.escapecroatioaservices.repository.RoomRepository;
import hr.tvz.zdelarec.escapecroatioaservices.service.finishedRoom.FinishedRoomService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(RoomService.class);

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

    /**
     * Autowired {@link FinishedRoomService}.
     */
    @Autowired
    private FinishedRoomService finishedRoomService;

    private RoomMapper roomMapper;


    @Override
    public List<RoomDto> getAllRooms(final String userId) {
        final List<FinishedRoomDto> finishedRoomDtoList = finishedRoomService.getAllFinishedRooms(userId);
        roomMapper = new RoomMapper(modelMapper, finishedRoomDtoList);
        final List<Room> roomList = (List<Room>) roomRepository.findAll();
        LOGGER.info("Found {} results", roomList.size());
        return roomList.stream().map(room -> roomMapper.mapToDto(room)).collect(Collectors.toList());
    }

    @Override
    public List<RoomDto> getAllRooms() {
        final List<Room> roomList = (List<Room>) roomRepository.findAll();
        LOGGER.info("Found {} results", roomList.size());
        return roomList.stream().map(room -> modelMapper.map(room, RoomDto.class)).collect(Collectors.toList());
    }

    @Override
    public RoomDto getRoomById(final Integer id, final String userId) {
        final List<FinishedRoomDto> finishedRoomDtoList = finishedRoomService.getAllFinishedRooms(userId);
        roomMapper = new RoomMapper(modelMapper, finishedRoomDtoList);
        final Room room = roomRepository.findById(id).orElseThrow();
        LOGGER.info("Found {} by room ID {}", room, room.getId());
        return roomMapper.mapToDto(room);
    }

    @Override
    public RoomDto getRoomById(final Integer id) {
        final Room room = roomRepository.findById(id).orElseThrow();
        LOGGER.info("Found {} by room ID {}", room, room.getId());
        return modelMapper.map(room, RoomDto.class);
    }

    @Override
    public List<RoomDto> getAllRoomsByPlaceId(final Integer id, final String userId) {
        final List<FinishedRoomDto> finishedRoomDtoList = finishedRoomService.getAllFinishedRooms(userId);
        roomMapper = new RoomMapper(modelMapper, finishedRoomDtoList);
        final List<Room> roomList = roomRepository.findAllByPlaceId(id);
        LOGGER.info("Found {} results with place ID {}", roomList.size(), id);
        return roomList.stream().map(room -> roomMapper.mapToDto(room)).collect(Collectors.toList());
    }

    @Override
    public List<RoomDto> getAllRoomsByPlaceId(final Integer id) {
        final List<Room> roomList = roomRepository.findAllByPlaceId(id);
        LOGGER.info("Found {} results with place ID {}", roomList.size(), id);
        return roomList.stream().map(room -> modelMapper.map(room, RoomDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<RoomDto> getAllRoomsByCityId(final Integer id, final String userId) {
        final List<FinishedRoomDto> finishedRoomDtoList = finishedRoomService.getAllFinishedRooms(userId);
        roomMapper = new RoomMapper(modelMapper, finishedRoomDtoList);
        final List<Room> roomList = roomRepository.findAllByCityId(id);
        LOGGER.info("Found {} results with city ID {}", roomList.size(), id);
        return roomList.stream().map(room -> roomMapper.mapToDto(room)).collect(Collectors.toList());
    }

    @Override
    public RoomDto save(final RoomDto roomDto) {
        return modelMapper.map(roomRepository.save(modelMapper.map(roomDto, Room.class)), RoomDto.class);
    }

    @Override
    public void delete(final RoomDto roomDto) {
        roomRepository.delete(modelMapper.map(roomDto, Room.class));
    }
}
