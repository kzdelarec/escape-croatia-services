package hr.tvz.zdelarec.escapecroatioaservices.service.statistics;

import hr.tvz.zdelarec.escapecroatioaservices.dto.StatisticsDto;

/**
 * Statistics service.
 *
 * @author kristijan.zdelarec
 */
public interface StatisticsService {

    /**
     * Method for fetching {@link StatisticsDto} by room identifier for the user.
     * @param roomId room identifier
     * @return {@link StatisticsDto} object
     */
    StatisticsDto getStatisticsByRoomId(Integer roomId);

}
