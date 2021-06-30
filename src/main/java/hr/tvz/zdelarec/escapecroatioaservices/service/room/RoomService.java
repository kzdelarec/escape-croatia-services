package hr.tvz.zdelarec.escapecroatioaservices.service.room;

import hr.tvz.zdelarec.escapecroatioaservices.entity.Room;

import java.util.List;
import java.util.Optional;

/**
 * Room service
 *
 * @author kristijan.zdelarec
 */
public interface RoomService {

    /**
     * Method for fetching {@link List} of {@link Room} objects.
     * @return {@link List} of {@link Room} objects
     */
    List<Room> getAllRooms();

    /**
     * Method for fetching one {@link Room} by id.
     * @param id {@link Room} id
     * @return {@link Room} object
     */
    Optional<Room> getRoomById(Integer id);
}
