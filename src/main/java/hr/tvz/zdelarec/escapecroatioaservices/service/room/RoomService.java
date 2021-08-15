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
     * @param userId user identifier
     * @return {@link List} of {@link RoomDto} objects
     */
    List<RoomDto> getAllRooms(String userId);

    /**
     * Method for fetching one {@link RoomDto} by id.
     * @param id {@link RoomDto} id
     * @param userId user identifier
     * @return {@link RoomDto} object
     */
    RoomDto getRoomById(Integer id, String userId);

    /**
     * Method for fetching {@link List} of {@link RoomDto} objects by place identifier.
     * @param userId user identifier
     * @param id place identifier
     * @return {@link List} of {@link RoomDto} objects
     */
    List<RoomDto> getAllRoomsByPlaceId(Integer id, String userId);

    /**
     * Method for fetching {@link List} of {@link RoomDto} objects by city identifier.
     * @param userId user identifier
     * @param id city identifier
     * @return {@link List} of {@link RoomDto} objects
     */
    List<RoomDto> getAllRoomsByCityId(Integer id, String userId);
}
