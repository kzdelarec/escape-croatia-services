package hr.tvz.zdelarec.escapecroatioaservices.api.controller;

import hr.tvz.zdelarec.escapecroatioaservices.dto.RoomDetailsDto;
import hr.tvz.zdelarec.escapecroatioaservices.service.room.RoomService;
import hr.tvz.zdelarec.escapecroatioaservices.service.roomDetails.RoomDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Controller for Room Details CRUD operations.
 *
 * @author kristijan.zdelarec
 */
@RestController
@RequestMapping(path = RoomDetailsController.BASE_URL)
@CrossOrigin
public class RoomDetailsController {

    /**
     * Base URL for Room details controller.
     */
    public static final String BASE_URL = "/api/roomDetails";

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(RoomDetailsController.class);

    /**
     * Autowired {@link RoomService}.
     */
    @Autowired
    private RoomDetailsService roomDetailsService;

    /**
     * Endpoint for fetching {@link RoomDetailsDto} object for user.
     *
     * @param id room identifier
     * @param userId user identifier
     * @return {@link RoomDetailsDto} object
     */
    @GetMapping(path = "/room/{id}", produces = RoomDetailsDto.CONTENT_TYPE)
    public RoomDetailsDto getByRoomId(@PathVariable("id") final Integer id, @RequestParam(name = "userId") final String userId) {
        LOGGER.info("Fetching rooms details by room ID: {}", id);
        return roomDetailsService.getOneRoomDetailsByRoomId(id, userId);
    }

    @PostMapping(consumes = RoomDetailsDto.CONTENT_TYPE, produces = RoomDetailsDto.CONTENT_TYPE)
    public RoomDetailsDto createRoomDetails(@RequestBody @Valid final RoomDetailsDto roomDetailsDto) {
        LOGGER.info("Creating room details with room ID {} for user {}", roomDetailsDto.getRoomId(), roomDetailsDto.getUserId());
        return roomDetailsService.save(roomDetailsDto);
    }
}
