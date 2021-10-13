package hr.tvz.zdelarec.escapecroatioaservices.service.v2.progress;

import hr.tvz.zdelarec.escapecroatioaservices.dto.ProgressDto;
import hr.tvz.zdelarec.escapecroatioaservices.dto.v2.RoomDtoV2;
import hr.tvz.zdelarec.escapecroatioaservices.enumeration.RoomStatusEnum;
import hr.tvz.zdelarec.escapecroatioaservices.service.progress.ProgressService;
import hr.tvz.zdelarec.escapecroatioaservices.service.room.RoomService;
import hr.tvz.zdelarec.escapecroatioaservices.service.v2.room.RoomServiceV2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * {@link ProgressService} implementation.
 *
 * @author kristijan.zdelarec
 */
@Service
public class ProgressServiceV2Impl implements ProgressServiceV2 {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ProgressService.class);

    /**
     * Autowired {@link RoomService}.
     *
     */
    @Autowired
    private RoomServiceV2 roomService;

    @Override
    public ProgressDto getProgressByCityId(final Integer cityId, final String userId) {
        final List<RoomDtoV2> roomDtoList = roomService.getAllRoomsByCityId(cityId, userId);
        return new ProgressDto(roomDtoList.size(), (int) roomDtoList.stream().filter(roomDto -> roomDto.getRoomStatus() != RoomStatusEnum.NOT_PLAYED).count());
    }

    @Override
    public ProgressDto getProgressByPlaceId(final Integer placeId, final String userId) {
        final List<RoomDtoV2> roomDtoList = roomService.getAllRoomsByPlaceId(placeId, userId);
        return new ProgressDto(roomDtoList.size(), (int) roomDtoList.stream().filter(roomDto -> roomDto.getRoomStatus() != RoomStatusEnum.NOT_PLAYED).count());
    }
}
