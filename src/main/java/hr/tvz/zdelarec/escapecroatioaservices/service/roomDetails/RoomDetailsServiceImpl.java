package hr.tvz.zdelarec.escapecroatioaservices.service.roomDetails;

import hr.tvz.zdelarec.escapecroatioaservices.dto.RoomDetailsDto;
import hr.tvz.zdelarec.escapecroatioaservices.entity.RoomDetails;
import hr.tvz.zdelarec.escapecroatioaservices.enumeration.RoomStatusEnum;
import hr.tvz.zdelarec.escapecroatioaservices.repository.RoomDetailsRepository;
import hr.tvz.zdelarec.escapecroatioaservices.repository.RoomRepository;
import hr.tvz.zdelarec.escapecroatioaservices.service.finishedRoom.FinishedRoomService;
import hr.tvz.zdelarec.escapecroatioaservices.service.room.RoomService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * {@link RoomDetailsService} implementation.
 *
 * @author kristijan.zdelarec
 */
@Service
public class RoomDetailsServiceImpl implements RoomDetailsService {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(RoomService.class);

    /**
     * Autowired {@link RoomRepository}.
     */
    @Autowired
    private RoomDetailsRepository roomDetailsRepository;

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

    @Override
    public RoomDetailsDto getOneRoomDetailsByRoomId(final Integer id, final String userId) {
        final RoomDetails roomDetails = roomDetailsRepository.findOneByRoomIdAndUserId(id, userId);
        LOGGER.info("Found {} ", roomDetails);
        if (roomDetails == null) {
            final RoomDetailsDto roomDetailsDto = new RoomDetailsDto();
            roomDetailsDto.setUserId(userId);
            roomDetailsDto.setRoomId(id);
            roomDetailsDto.setRoomStatus(RoomStatusEnum.NOT_PLAYED);
            return roomDetailsDto;
        } else {
            return modelMapper.map(roomDetails, RoomDetailsDto.class);
        }
    }

    @Override
    public List<RoomDetailsDto> getAllRoomDetailsByUserId(final String userId) {
        final List<RoomDetails> roomDetailsList = roomDetailsRepository.findAllByUserId(userId);
        LOGGER.info("Found {} results for user {}", roomDetailsList.size(), userId);
        return roomDetailsList.stream().map(roomDetails -> modelMapper.map(roomDetails, RoomDetailsDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<RoomDetailsDto> getAllRoomDetailsByRoomIdAndRoomStatusNot(final Integer roomId, final RoomStatusEnum status) {
        final List<RoomDetails> roomDetailsList = roomDetailsRepository.findAllByRoomIdAndRoomStatusNot(roomId, status);
        LOGGER.info("Found {} results", roomDetailsList.size());
        return roomDetailsList.stream().map(roomDetails -> modelMapper.map(roomDetails, RoomDetailsDto.class)).collect(Collectors.toList());
    }


    @Override
    public RoomDetailsDto save(final RoomDetailsDto roomDetailsDto) {
        return modelMapper.map(roomDetailsRepository.save(modelMapper.map(roomDetailsDto, RoomDetails.class)), RoomDetailsDto.class);
    }

    @Override
    public void delete(final RoomDetailsDto roomDetailsDto) {
        roomDetailsRepository.delete(modelMapper.map(roomDetailsDto, RoomDetails.class));
    }
}
