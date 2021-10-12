package hr.tvz.zdelarec.escapecroatioaservices.repository;

import hr.tvz.zdelarec.escapecroatioaservices.entity.RoomDetails;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Place repository.
 *
 * @author kristijan.zdelarec
 */
public interface RoomDetailsRepository extends CrudRepository<RoomDetails, Integer> {

    /**
     * Find all rooms details by room and user identifier.
     * @param roomId room identifier
     * @param userId user identifier
     * @return {@link RoomDetails} object
     */
    RoomDetails findOneByRoomIdAndUserId(Integer roomId, String userId);

    /**
     * Find all rooms details by room and user identifier.
     * @param userId user identifier
     * @return {@link RoomDetails} object
     */
    List<RoomDetails> findAllByUserId(String userId);

}
