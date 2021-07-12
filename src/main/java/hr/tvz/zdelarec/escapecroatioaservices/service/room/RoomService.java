package hr.tvz.zdelarec.escapecroatioaservices.service.room;

import hr.tvz.zdelarec.escapecroatioaservices.dto.RoomDto;

import java.util.List;

/**
 * Room service.
 *
 * @author kristijan.zdelarec
 */
public interface RoomService {

    /**
     * Method for fetching {@link List} of {@link RoomDto} objects.
     * @return {@link List} of {@link RoomDto} objects
     */
    List<RoomDto> getAllRooms();

    /**
     * Method for fetching one {@link RoomDto} by id.
     * @param id {@link RoomDto} id
     * @return {@link RoomDto} object
     */
    RoomDto getRoomById(Integer id);

    /**
     * Method for fetching {@link List} of {@link RoomDto} objects by place identifier.
     * @param id place identifier
     * @return {@link List} of {@link RoomDto} objects
     */
    List<RoomDto> getAllRoomsByPlaceId(Integer id);
}
