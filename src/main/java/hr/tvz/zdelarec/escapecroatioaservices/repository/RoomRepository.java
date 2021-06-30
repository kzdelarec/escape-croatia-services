package hr.tvz.zdelarec.escapecroatioaservices.repository;

import hr.tvz.zdelarec.escapecroatioaservices.entity.Room;
import org.springframework.data.repository.CrudRepository;

/**
 * Place repository.
 *
 * @author kristijan.zdelarec
 */
public interface RoomRepository extends CrudRepository<Room, Integer> {
}
