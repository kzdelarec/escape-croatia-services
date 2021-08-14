package hr.tvz.zdelarec.escapecroatioaservices.service.finishedRoom;

import hr.tvz.zdelarec.escapecroatioaservices.dto.FinishedRoomDto;
import hr.tvz.zdelarec.escapecroatioaservices.entity.FinishedRoom;
import hr.tvz.zdelarec.escapecroatioaservices.repository.FinishedRoomsRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * {@link FinishedRoomService} implementation.
 *
 * @author kristijan.zdelarec
 */
@Service
public class FinishedRoomServiceImpl implements FinishedRoomService {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(FinishedRoomService.class);

    /**
     * Autowired {@link FinishedRoomsRepository}.
     *
     */
    @Autowired
    private FinishedRoomsRepository finishedRoomsRepository;

    /**
     * Autowired {@link ModelMapper}.
     */
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<FinishedRoomDto> getAllFinishedRooms(final String userId) {
        final List<FinishedRoom> finishedRoomList = finishedRoomsRepository.findAllByUserId(userId);
        LOGGER.info("Found {} results for user {}", finishedRoomList.size(), userId);
        return finishedRoomList.stream().map(finishedRoom -> modelMapper.map(finishedRoom, FinishedRoomDto.class)).collect(Collectors.toList());
    }

    @Override
    public FinishedRoomDto getOneFinishedRoom(final FinishedRoomDto finishedRoomDto) {
        final FinishedRoom finishedRoom = finishedRoomsRepository.findOneByUserIdAndPlaceId(finishedRoomDto.getUserId(), finishedRoomDto.getPlaceId());
        LOGGER.info("Found {}  for user {}", finishedRoom, finishedRoomDto.getUserId());
        return modelMapper.map(finishedRoom, FinishedRoomDto.class);
    }

    @Override
    public FinishedRoomDto createFinishedRoom(final FinishedRoomDto finishedRoomDto) {
        if (existsByUserIdAndRoomId(finishedRoomDto)) {
            LOGGER.info("Favourite with place ID {}  for user {} already exists.", finishedRoomDto.getPlaceId(), finishedRoomDto.getUserId());
            return finishedRoomDto;
        } else {
            final FinishedRoom finishedRoom = finishedRoomsRepository.save(modelMapper.map(finishedRoomDto, FinishedRoom.class));
            LOGGER.info("Created favourite with place ID {}  for user {}.", finishedRoomDto.getPlaceId(), finishedRoomDto.getUserId());
            return modelMapper.map(finishedRoom, FinishedRoomDto.class);
        }
    }

    @Override
    public void deleteFinishedRoom(final FinishedRoomDto finishedRoomDto) {
        if (existsByUserIdAndRoomId(finishedRoomDto)) {
            final FinishedRoom finishedRoom = finishedRoomsRepository.findOneByUserIdAndPlaceId(finishedRoomDto.getUserId(), finishedRoomDto.getPlaceId());
            if (finishedRoom != null) {
                finishedRoomsRepository.delete(finishedRoom);
                LOGGER.info("Removed favourite with place ID {}  for user {}.", finishedRoom.getPlaceId(), finishedRoom.getUserId());
            }
        } else {
            LOGGER.info("Favourite with place ID {}  for user {} does not exist.", finishedRoomDto.getPlaceId(), finishedRoomDto.getUserId());
        }
    }

    @Override
    public Boolean existsByUserIdAndRoomId(final FinishedRoomDto finishedRoomDto) {
        return finishedRoomsRepository.existsByUserIdAndRoomId(finishedRoomDto.getUserId(), finishedRoomDto.getRoomId());
    }
}
