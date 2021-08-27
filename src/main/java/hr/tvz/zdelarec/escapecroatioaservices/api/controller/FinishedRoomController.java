package hr.tvz.zdelarec.escapecroatioaservices.api.controller;

import hr.tvz.zdelarec.escapecroatioaservices.dto.FinishedRoomDto;
import hr.tvz.zdelarec.escapecroatioaservices.service.finishedRoom.FinishedRoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Controller for Finished rooms CRUD operations.
 *
 * @author kristijan.zdelarec
 */
@RestController
@RequestMapping(path = FinishedRoomController.BASE_URL)
@CrossOrigin
public class FinishedRoomController {
    /**
     * Base URL for Finished rooms controller.
     */
    public static final String BASE_URL = "/api/finished";

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(FinishedRoomController.class);

    /**
     * Autowired {@link FinishedRoomService}.
     */
    @Autowired
    private FinishedRoomService finishedRoomService;


    @PostMapping(consumes = FinishedRoomDto.CONTENT_TYPE, produces = FinishedRoomDto.CONTENT_TYPE)
    public FinishedRoomDto createFinishedRoom(@RequestBody @Valid final FinishedRoomDto finishedRoomDto) {
        LOGGER.info("Creating finished room with room ID {} for user {}", finishedRoomDto.getRoomId(), finishedRoomDto.getUserId());
        return finishedRoomService.createFinishedRoom(finishedRoomDto);
    }

    @DeleteMapping(consumes = FinishedRoomDto.CONTENT_TYPE)
    public void removeFinishedRoom(@RequestBody @Valid final FinishedRoomDto finishedRoomDto) {
        LOGGER.info("Removing finished room with room ID {} for user {}", finishedRoomDto.getRoomId(), finishedRoomDto.getUserId());
        finishedRoomService.deleteFinishedRoom(finishedRoomDto);
    }
}
