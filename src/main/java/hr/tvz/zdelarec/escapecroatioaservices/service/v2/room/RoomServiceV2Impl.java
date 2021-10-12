package hr.tvz.zdelarec.escapecroatioaservices.service.v2.room;

import hr.tvz.zdelarec.escapecroatioaservices.dto.RoomDetailsDto;
import hr.tvz.zdelarec.escapecroatioaservices.dto.v2.RoomDtoV2;
import hr.tvz.zdelarec.escapecroatioaservices.entity.Room;
import hr.tvz.zdelarec.escapecroatioaservices.mapper.impl.RoomMapperV2;
import hr.tvz.zdelarec.escapecroatioaservices.repository.RoomRepository;
import hr.tvz.zdelarec.escapecroatioaservices.service.finishedRoom.FinishedRoomService;
import hr.tvz.zdelarec.escapecroatioaservices.service.room.RoomService;
import hr.tvz.zdelarec.escapecroatioaservices.service.roomDetails.RoomDetailsService;
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
public class RoomServiceV2Impl implements RoomServiceV2 {

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
    private RoomDetailsService roomDetailsService;

    private RoomMapperV2 roomMapper;


    @Override
    public List<RoomDtoV2> getAllRooms(final String userId) {
        final List<RoomDetailsDto> roomDetailsDtoList = roomDetailsService.getAllRoomDetailsByUserId(userId);
        roomMapper = new RoomMapperV2(modelMapper, roomDetailsDtoList);
        final List<Room> roomList = (List<Room>) roomRepository.findAll();
        LOGGER.info("Found {} results", roomList.size());
        return roomList.stream().map(room -> roomMapper.mapToDto(room)).collect(Collectors.toList());
    }

    @Override
    public List<RoomDtoV2> getAllRooms() {
        final List<Room> roomList = (List<Room>) roomRepository.findAll();
        LOGGER.info("Found {} results", roomList.size());
        return roomList.stream().map(room -> modelMapper.map(room, RoomDtoV2.class)).collect(Collectors.toList());
    }

    @Override
    public RoomDtoV2 getRoomById(final Integer id, final String userId) {
        final List<RoomDetailsDto> roomDetailsDtoList = roomDetailsService.getAllRoomDetailsByUserId(userId);
        roomMapper = new RoomMapperV2(modelMapper, roomDetailsDtoList);
        final Room room = roomRepository.findById(id).orElseThrow();
        LOGGER.info("Found {} by room ID {}", room, room.getId());
        return roomMapper.mapToDto(room);
    }

    @Override
    public RoomDtoV2 getRoomById(final Integer id) {
        final Room room = roomRepository.findById(id).orElseThrow();
        LOGGER.info("Found {} by room ID {}", room, room.getId());
        return modelMapper.map(room, RoomDtoV2.class);
    }

    @Override
    public List<RoomDtoV2> getAllRoomsByPlaceId(final Integer id, final String userId) {
        final List<RoomDetailsDto> roomDetailsDtoList = roomDetailsService.getAllRoomDetailsByUserId(userId);
        roomMapper = new RoomMapperV2(modelMapper, roomDetailsDtoList);
        final List<Room> roomList = roomRepository.findAllByPlaceId(id);
        LOGGER.info("Found {} results with place ID {}", roomList.size(), id);
        return roomList.stream().map(room -> roomMapper.mapToDto(room)).collect(Collectors.toList());
    }

    @Override
    public List<RoomDtoV2> getAllRoomsByPlaceId(final Integer id) {
        final List<Room> roomList = roomRepository.findAllByPlaceId(id);
        LOGGER.info("Found {} results with place ID {}", roomList.size(), id);
        return roomList.stream().map(room -> modelMapper.map(room, RoomDtoV2.class)).collect(Collectors.toList());
    }

    @Override
    public List<RoomDtoV2> getAllRoomsByCityId(final Integer id, final String userId) {
        final List<RoomDetailsDto> roomDetailsDtoList = roomDetailsService.getAllRoomDetailsByUserId(userId);
        roomMapper = new RoomMapperV2(modelMapper, roomDetailsDtoList);
        final List<Room> roomList = roomRepository.findAllByCityId(id);
        LOGGER.info("Found {} results with city ID {}", roomList.size(), id);
        return roomList.stream().map(room -> roomMapper.mapToDto(room)).collect(Collectors.toList());
    }

    @Override
    public RoomDtoV2 save(final RoomDtoV2 roomDto) {
        return modelMapper.map(roomRepository.save(modelMapper.map(roomDto, Room.class)), RoomDtoV2.class);
    }

    @Override
    public void delete(final RoomDtoV2 roomDto) {
        roomRepository.delete(modelMapper.map(roomDto, Room.class));
    }
}
