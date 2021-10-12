package hr.tvz.zdelarec.escapecroatioaservices.service.v2.room;

import hr.tvz.zdelarec.escapecroatioaservices.dto.v2.RoomDtoV2;

import java.util.List;

/**
 * Room service.
 *
 * @author kristijan.zdelarec
 */
public interface RoomServiceV2 {

    /**
     * Method for fetching {@link List} of {@link RoomDtoV2} objects.
     * @param userId user identifier
     * @return {@link List} of {@link RoomDtoV2} objects
     */
    List<RoomDtoV2> getAllRooms(String userId);

    /**
     * Method for fetching {@link List} of {@link RoomDtoV2} objects.
     * @return {@link List} of {@link RoomDtoV2} objects
     */
    List<RoomDtoV2> getAllRooms();

    /**
     * Method for fetching one {@link RoomDtoV2} by id.
     * @param id {@link RoomDtoV2} id
     * @param userId user identifier
     * @return {@link RoomDtoV2} object
     */
    RoomDtoV2 getRoomById(Integer id, String userId);

    /**
     * Method for fetching one {@link RoomDtoV2} by id.
     * @param id {@link RoomDtoV2} id
     * @return {@link RoomDtoV2} object
     */
    RoomDtoV2 getRoomById(Integer id);

    /**
     * Method for fetching {@link List} of {@link RoomDtoV2} objects by place identifier.
     * @param userId user identifier
     * @param id place identifier
     * @return {@link List} of {@link RoomDtoV2} objects
     */
    List<RoomDtoV2> getAllRoomsByPlaceId(Integer id, String userId);

    /**
     * Method for fetching {@link List} of {@link RoomDtoV2} objects by place identifier.
     * @param id place identifier
     * @return {@link List} of {@link RoomDtoV2} objects
     */
    List<RoomDtoV2> getAllRoomsByPlaceId(Integer id);

    /**
     * Method for fetching {@link List} of {@link RoomDtoV2} objects by city identifier.
     * @param userId user identifier
     * @param id city identifier
     * @return {@link List} of {@link RoomDtoV2} objects
     */
    List<RoomDtoV2> getAllRoomsByCityId(Integer id, String userId);

    /**
     * Method for saving new or updated {@link RoomDtoV2} object.
     * @param roomDto {@link RoomDtoV2} object
     * @return saved {@link RoomDtoV2} object
     */
    RoomDtoV2 save(RoomDtoV2 roomDto);

    /**
     * Method for deleting a {@link RoomDtoV2} object.
     * @param roomDto {@link RoomDtoV2} object
     */
    void delete(RoomDtoV2 roomDto);
}
