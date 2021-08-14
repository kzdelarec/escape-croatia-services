package hr.tvz.zdelarec.escapecroatioaservices.service.finishedRoom;

import hr.tvz.zdelarec.escapecroatioaservices.dto.FinishedRoomDto;

import java.util.List;

/**
 * Finished room service.
 *
 * @author kristijan.zdelarec
 */
public interface FinishedRoomService {

    /**
     * Method for fetching {@link List} of {@link FinishedRoomDto} objects by user identifier.
     * @param userId usr identifier
     * @return {@link List} of {@link FinishedRoomDto} objects
     */
    List<FinishedRoomDto> getAllFinishedRooms(String userId);

    /**
     * Method for fetching one {@link FinishedRoomDto} object.
     * @param finishedRoomDto {@link FinishedRoomDto} object
     * @return {@link FinishedRoomDto} object
     */
    FinishedRoomDto getOneFinishedRoom(FinishedRoomDto finishedRoomDto);

    /**
     * Method for creating new {@link FinishedRoomDto} object.
     * @param finishedRoomDto {@link FinishedRoomDto} object
     * @return saved {@link FinishedRoomDto} object
     */
    FinishedRoomDto createFinishedRoom(FinishedRoomDto finishedRoomDto);

    /**
     * Method for deleting existing {@link FinishedRoomDto} object.
     * @param finishedRoomDto {@link FinishedRoomDto} object
     */
    void deleteFinishedRoom(FinishedRoomDto finishedRoomDto);

    /**
     * Check if {@link FinishedRoomDto} exists.
     * @param finishedRoomDto {@link FinishedRoomDto} object
     * @return {@link Boolean}
     */
    Boolean existsByUserIdAndPlaceId(FinishedRoomDto finishedRoomDto);
}
