package hr.tvz.zdelarec.escapecroatioaservices.service.progress;

import hr.tvz.zdelarec.escapecroatioaservices.dto.ProgressDto;
import hr.tvz.zdelarec.escapecroatioaservices.dto.RoomDto;
import hr.tvz.zdelarec.escapecroatioaservices.service.room.RoomService;
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
public class ProgressServiceImpl implements ProgressService {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ProgressService.class);

    /**
     * Autowired {@link RoomService}.
     *
     */
    @Autowired
    private RoomService roomService;

    @Override
    public ProgressDto getProgressByCityId(final Integer cityId, final String userId) {
        final List<RoomDto> roomDtoList = roomService.getAllRoomsByCityId(cityId, userId);
        return new ProgressDto(roomDtoList.size(), (int) roomDtoList.stream().filter(RoomDto::getFinished).count());
    }

    @Override
    public ProgressDto getProgressByPlaceId(final Integer placeId, final String userId) {
        final List<RoomDto> roomDtoList = roomService.getAllRoomsByPlaceId(placeId, userId);
        return new ProgressDto(roomDtoList.size(), (int) roomDtoList.stream().filter(RoomDto::getFinished).count());
    }
}
