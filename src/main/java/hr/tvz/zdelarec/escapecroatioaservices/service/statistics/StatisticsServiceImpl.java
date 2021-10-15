package hr.tvz.zdelarec.escapecroatioaservices.service.statistics;

import hr.tvz.zdelarec.escapecroatioaservices.dto.RoomDetailsDto;
import hr.tvz.zdelarec.escapecroatioaservices.dto.StatisticsDto;
import hr.tvz.zdelarec.escapecroatioaservices.enumeration.RoomStatusEnum;
import hr.tvz.zdelarec.escapecroatioaservices.service.progress.ProgressService;
import hr.tvz.zdelarec.escapecroatioaservices.service.roomDetails.RoomDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * {@link StatisticsService} implementation.
 *
 * @author kristijan.zdelarec
 */
@Service
public class StatisticsServiceImpl implements StatisticsService {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ProgressService.class);

    /**
     * Autowired {@link RoomDetailsService}.
     *
     */
    @Autowired
    private RoomDetailsService roomDetailsService;

    @Override
    public StatisticsDto getStatisticsByRoomId(final Integer roomId) {
        final List<RoomDetailsDto> roomDetailsDtoList = roomDetailsService.getAllRoomDetailsByRoomIdAndRoomStatusNot(roomId, RoomStatusEnum.NOT_PLAYED);
        final List<RoomDetailsDto> roomDetailsWithRating = roomDetailsDtoList.stream().filter(roomDetailsDto -> roomDetailsDto.getRating() != null).collect(Collectors.toList());
        final List<RoomDetailsDto> roomDetailsWon = roomDetailsDtoList.stream().filter(roomDetailsDto -> roomDetailsDto.getRoomStatus() == RoomStatusEnum.GAME_WON).collect(Collectors.toList());
        final StatisticsDto statisticsDto = new StatisticsDto();

        //rating
        if (roomDetailsWithRating.isEmpty()) {
            statisticsDto.setRating(new BigDecimal(0));
        } else {
            final Integer sum = roomDetailsWithRating.stream().map(RoomDetailsDto::getRating).reduce(0, Integer::sum);
            statisticsDto.setRating(new BigDecimal(sum / roomDetailsWithRating.size()));
        }

        //success rate
        if (roomDetailsWon.isEmpty()) {
            statisticsDto.setSuccessRate(new BigDecimal(0));
        } else {
            statisticsDto.setSuccessRate(new BigDecimal(roomDetailsWon.size() / roomDetailsDtoList.size()));
        }

        return statisticsDto;
    }
}
