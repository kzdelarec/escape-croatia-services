package hr.tvz.zdelarec.escapecroatioaservices.repository;

import hr.tvz.zdelarec.escapecroatioaservices.entity.Room;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Room repository.
 *
 * @author kristijan.zdelarec
 */
public interface RoomRepository extends CrudRepository<Room, Integer> {

    /**
     * Find all rooms by place identifier.
     * @param id place identifier
     * @return {@link List} of {@link Room} objects
     */
    List<Room> findAllByPlaceId(Integer id);

    /**
     * Find all rooms by city identifier.
     * @param id city identifier
     * @return {@link List} of {@link Room} objects
     */
    List<Room> findAllByCityId(Integer id);
}
