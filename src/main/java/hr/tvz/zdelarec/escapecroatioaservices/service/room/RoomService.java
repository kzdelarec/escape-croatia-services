package hr.tvz.zdelarec.escapecroatioaservices.service.room;

import hr.tvz.zdelarec.escapecroatioaservices.dto.PlaceDto;
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
     * Method for fetching {@link List} of {@link RoomDto} objects.
     * @return {@link List} of {@link RoomDto} objects
     */
    List<RoomDto> getAllRooms();

    /**
     * Method for fetching {@link List} of {@link RoomDto} objects.
     *
     * @param placeIds {@link PlaceDto} identifiers
     * @return {@link List} of {@link RoomDto} objects
     */
    List<RoomDto> getAllRooms(List<Integer> placeIds);

    /**
     * Method for fetching {@link List} of {@link RoomDto} objects by authority.
     * @return {@link List} of {@link RoomDto} objects
     */
    List<RoomDto> getRoomsByAuthority();

    /**
     * Method for fetching one {@link RoomDto} by id.
     * @param id {@link RoomDto} id
     * @param userId user identifier
     * @return {@link RoomDto} object
     */
    RoomDto getRoomById(Integer id, String userId);

    /**
     * Method for fetching one {@link RoomDto} by id.
     * @param id {@link RoomDto} id
     * @return {@link RoomDto} object
     */
    RoomDto getRoomById(Integer id);

    /**
     * Method for fetching {@link List} of {@link RoomDto} objects by place identifier.
     * @param userId user identifier
     * @param id place identifier
     * @return {@link List} of {@link RoomDto} objects
     */
    List<RoomDto> getAllRoomsByPlaceId(Integer id, String userId);

    /**
     * Method for fetching {@link List} of {@link RoomDto} objects by place identifier.
     * @param id place identifier
     * @return {@link List} of {@link RoomDto} objects
     */
    List<RoomDto> getAllRoomsByPlaceId(Integer id);

    /**
     * Method for fetching {@link List} of {@link RoomDto} objects by city identifier.
     * @param userId user identifier
     * @param id city identifier
     * @return {@link List} of {@link RoomDto} objects
     */
    List<RoomDto> getAllRoomsByCityId(Integer id, String userId);

    /**
     * Method for saving new or updated {@link RoomDto} object.
     * @param roomDto {@link RoomDto} object
     * @return saved {@link RoomDto} object
     */
    RoomDto save(RoomDto roomDto);

    /**
     * Method for deleting a {@link RoomDto} object.
     * @param roomDto {@link RoomDto} object
     */
    void delete(RoomDto roomDto);
}
