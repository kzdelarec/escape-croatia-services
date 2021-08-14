package hr.tvz.zdelarec.escapecroatioaservices.repository;

import hr.tvz.zdelarec.escapecroatioaservices.entity.FinishedRoom;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Finished rooms repository.
 *
 * @author kristijan.zdelarec
 */
public interface FinishedRoomsRepository extends CrudRepository<FinishedRoom, Integer> {

    /**
     * Fetch all {@link FinishedRoom} objects by user identifier.
     * @param userId user identifier
     * @return {@link List} of {@link FinishedRoom} objects
     */
    List<FinishedRoom> findAllByUserId(String userId);

    /**
     * Fetch one {@link FinishedRoom} object by user and place identifier.
     * @param userId user identifier
     * @param placeId place identifier
     * @return {@link FinishedRoom} object
     */
    FinishedRoom findOneByUserIdAndPlaceId(String userId, Integer placeId);

    /**
     * Check if {@link FinishedRoom} exists.
     * @param userId user identifier
     * @param roomId room identifier
     * @return {@link Boolean}
     */
    Boolean existsByUserIdAndRoomId(String userId, Integer roomId);

}
