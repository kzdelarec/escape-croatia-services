package hr.tvz.zdelarec.escapecroatioaservices.api.controller.v2;

import hr.tvz.zdelarec.escapecroatioaservices.dto.ProgressDto;
import hr.tvz.zdelarec.escapecroatioaservices.service.progress.ProgressService;
import hr.tvz.zdelarec.escapecroatioaservices.service.v2.progress.ProgressServiceV2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for Progress CRUD operations.
 *
 * @author kristijan.zdelarec
 */
@RestController
@RequestMapping(path = ProgressControllerV2.BASE_URL)
@CrossOrigin
public class ProgressControllerV2 {
    /**
     * Base URL for Progress controller.
     */
    public static final String BASE_URL = "/api/v2/progress";

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ProgressControllerV2.class);

    /**
     * Autowired {@link ProgressService}.
     */
    @Autowired
    private ProgressServiceV2 progressService;

    /**
     * Endpoint for fetching {@link ProgressDto} objects by city identifier.
     *
     * @param id City identifier
     * @param userId user identifier
     * @return {@link ProgressDto} object
     */
    @GetMapping(path = "/city/{id}", produces = ProgressDto.CONTENT_TYPE)
    public ProgressDto getByCityId(@PathVariable("id") final Integer id, @RequestParam(name = "userId") final String userId) {
        LOGGER.info("Fetching progress for city ID {} for user {}", id, userId);
        return progressService.getProgressByCityId(id, userId);
    }

    /**
     * Endpoint for fetching {@link ProgressDto} objects by place identifier.
     *
     * @param id City identifier
     * @param userId user identifier
     * @return {@link ProgressDto} object
     */
    @GetMapping(path = "/place/{id}", produces = ProgressDto.CONTENT_TYPE)
    public ProgressDto getByPlaceId(@PathVariable("id") final Integer id, @RequestParam(name = "userId") final String userId) {
        LOGGER.info("Fetching progress for place ID {} for user {}", id, userId);
        return progressService.getProgressByPlaceId(id, userId);
    }

}
