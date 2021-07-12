package hr.tvz.zdelarec.escapecroatioaservices.controller;

import hr.tvz.zdelarec.escapecroatioaservices.dto.RoomDto;
import hr.tvz.zdelarec.escapecroatioaservices.service.room.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller for Room CRUD operations.
 *
 * @author kristijan.zdelarec
 */
@RestController
@RequestMapping(path = RoomController.BASE_URL)
@CrossOrigin
public class RoomController {

    /**
     * Base URL for Room controller.
     */
    public static final String BASE_URL = "/room";

    /**
     * Autowired {@link RoomService}.
     */
    @Autowired
    private RoomService roomService;

    /**
     * Endpoint for fetching all {@link RoomDto} objects.
     *
     * @return fetched {@link List} of {@link RoomDto} objects
     */
    @GetMapping(produces = RoomDto.CONTENT_TYPE)
    public List<RoomDto> getAll() {
        return roomService.getAllRooms();
    }

    /**
     * Endpoint for fetching {@link RoomDto} object.
     *
     * @param id object identifier
     * @return {@link RoomDto} object
     */
    @GetMapping(path = "/{id}", produces = RoomDto.CONTENT_TYPE)
    public RoomDto getById(@PathVariable("id") final Integer id) {
        return roomService.getRoomById(id);
    }

    /**
     * Endpoint for fetching all {@link RoomDto} objects by Place identifier.
     *
     * @param id Place identifier
     * @return {@link RoomDto} object
     */
    @GetMapping(path = "/place/{id}", produces = RoomDto.CONTENT_TYPE)
    public List<RoomDto> getByPlaceId(@PathVariable("id") final Integer id) {
        return roomService.getAllRoomsByPlaceId(id);
    }
}
