package hr.tvz.zdelarec.escapecroatioaservices.api.controller;

import hr.tvz.zdelarec.escapecroatioaservices.dto.ProgressDto;
import hr.tvz.zdelarec.escapecroatioaservices.dto.StatisticsDto;
import hr.tvz.zdelarec.escapecroatioaservices.service.statistics.StatisticsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for Statistics CRUD operations.
 *
 * @author kristijan.zdelarec
 */
@RestController
@RequestMapping(path = StatisticsController.BASE_URL)
@CrossOrigin
public class StatisticsController {
    /**
     * Base URL for Statistics controller.
     */
    public static final String BASE_URL = "/api/statistics";

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(StatisticsController.class);

    /**
     * Autowired {@link StatisticsService}.
     */
    @Autowired
    private StatisticsService statisticsService;

    /**
     * Endpoint for fetching {@link StatisticsDto} objects by room identifier.
     *
     * @param id room identifier
     * @return {@link ProgressDto} object
     */
    @GetMapping(path = "/room/{id}", produces = StatisticsDto.CONTENT_TYPE)
    public StatisticsDto getByRoomId(@PathVariable("id") final Integer id) {
        LOGGER.info("Fetching statistics for room ID {}", id);
        return statisticsService.getStatisticsByRoomId(id);
    }
}
