package hr.tvz.zdelarec.escapecroatioaservices.service.roomDetails;

import hr.tvz.zdelarec.escapecroatioaservices.dto.RoomDetailsDto;
import hr.tvz.zdelarec.escapecroatioaservices.enumeration.RoomStatusEnum;

import java.util.List;

/**
 * Room service.
 *
 * @author kristijan.zdelarec
 */
public interface RoomDetailsService {

    /**
     * Method for fetching {@link RoomDetailsDto} object for user.
     * @param userId user identifier
     * @param id room identifier
     * @return {@link RoomDetailsDto} object
     */
    RoomDetailsDto getOneRoomDetailsByRoomId(Integer id, String userId);

    /**
     * Method for fetching all {@link RoomDetailsDto} objects for user.
     * @param userId user identifier
     * @return {@link RoomDetailsDto} objects
     */
    List<RoomDetailsDto> getAllRoomDetailsByUserId(String userId);

    /**
     * Find all {@link RoomDetailsDto} objects by status.
     * @param roomId room identifier
     * @param status {@link RoomStatusEnum} enum
     * @return list of {@link RoomDetailsDto} objects
     */
    List<RoomDetailsDto> getAllRoomDetailsByRoomIdAndRoomStatusNot(Integer roomId, RoomStatusEnum status);

    /**
     * Method for saving new or updated {@link RoomDetailsDto} object.
     * @param roomDetailsDto {@link RoomDetailsDto} object
     * @return saved {@link RoomDetailsDto} object
     */
    RoomDetailsDto save(RoomDetailsDto roomDetailsDto);

    /**
     * Method for deleting a {@link RoomDetailsDto} object.
     * @param roomDetailsDto {@link RoomDetailsDto} object
     */
    void delete(RoomDetailsDto roomDetailsDto);
}
