package hr.tvz.zdelarec.escapecroatioaservices.service.progress;

import hr.tvz.zdelarec.escapecroatioaservices.dto.FinishedRoomDto;
import hr.tvz.zdelarec.escapecroatioaservices.dto.ProgressDto;

/**
 * progress service.
 *
 * @author kristijan.zdelarec
 */
public interface ProgressService {

    /**
     * Method for fetching {@link ProgressDto} by city identifier for the user.
     * @param cityId city identifier
     * @param userId user identifier
     * @return {@link FinishedRoomDto} object
     */
    ProgressDto getProgressByCityId(Integer cityId, String userId);

    /**
     * Method for fetching {@link ProgressDto} by place identifier for the user.
     * @param placeId place identifier
     * @param userId user identifier
     * @return {@link FinishedRoomDto} object
     */
    ProgressDto getProgressByPlaceId(Integer placeId, String userId);

}
