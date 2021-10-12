package hr.tvz.zdelarec.escapecroatioaservices.api.controller.v2;

import hr.tvz.zdelarec.escapecroatioaservices.dto.v2.RoomDtoV2;
import hr.tvz.zdelarec.escapecroatioaservices.service.room.RoomService;
import hr.tvz.zdelarec.escapecroatioaservices.service.v2.room.RoomServiceV2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller for Room CRUD operations.
 *
 * @author kristijan.zdelarec
 */
@RestController
@RequestMapping(path = RoomControllerV2.BASE_URL)
@CrossOrigin
public class RoomControllerV2 {

    /**
     * Base URL for Room controller.
     */
    public static final String BASE_URL = "/api/v2/room";

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(RoomControllerV2.class);

    /**
     * Autowired {@link RoomService}.
     */
    @Autowired
    private RoomServiceV2 roomService;

    /**
     * Endpoint for fetching all {@link RoomDtoV2} objects.
     * @param userId user identifier
     * @return fetched {@link List} of {@link RoomDtoV2} objects
     */
    @GetMapping(produces = RoomDtoV2.CONTENT_TYPE)
    public List<RoomDtoV2> getAll(@RequestParam(name = "userId") final String userId) {
        LOGGER.info("Fetching all rooms...");
        return roomService.getAllRooms(userId);
    }

    /**
     * Endpoint for fetching {@link RoomDtoV2} object.
     *
     * @param id object identifier
     * @param userId user identifier
     * @return {@link RoomDtoV2} object
     */
    @GetMapping(path = "/{id}", produces = RoomDtoV2.CONTENT_TYPE)
    public RoomDtoV2 getById(@PathVariable("id") final Integer id, @RequestParam(name = "userId") final String userId) {
        LOGGER.info("Fetching one room with ID: {}", id);
        return roomService.getRoomById(id, userId);
    }

    /**
     * Endpoint for fetching all {@link RoomDtoV2} objects by Place identifier.
     *
     * @param id Place identifier
     * @param userId user identifier
     * @return {@link RoomDtoV2} object
     */
    @GetMapping(path = "/place/{id}", produces = RoomDtoV2.CONTENT_TYPE)
    public List<RoomDtoV2> getByPlaceId(@PathVariable("id") final Integer id, @RequestParam(name = "userId") final String userId) {
        LOGGER.info("Fetching all rooms by place ID: {}", id);
        return roomService.getAllRoomsByPlaceId(id, userId);
    }
}
