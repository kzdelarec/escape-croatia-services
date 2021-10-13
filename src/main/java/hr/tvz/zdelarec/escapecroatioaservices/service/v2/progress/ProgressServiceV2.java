package hr.tvz.zdelarec.escapecroatioaservices.service.v2.progress;

import hr.tvz.zdelarec.escapecroatioaservices.dto.ProgressDto;

/**
 * progress service.
 *
 * @author kristijan.zdelarec
 */
public interface ProgressServiceV2 {

    /**
     * Method for fetching {@link ProgressDto} by city identifier for the user.
     * @param cityId city identifier
     * @param userId user identifier
     * @return {@link ProgressDto} object
     */
    ProgressDto getProgressByCityId(Integer cityId, String userId);

    /**
     * Method for fetching {@link ProgressDto} by place identifier for the user.
     * @param placeId place identifier
     * @param userId user identifier
     * @return {@link ProgressDto} object
     */
    ProgressDto getProgressByPlaceId(Integer placeId, String userId);

}
