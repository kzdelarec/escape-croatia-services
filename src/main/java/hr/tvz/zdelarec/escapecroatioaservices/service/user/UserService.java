package hr.tvz.zdelarec.escapecroatioaservices.service.user;

import hr.tvz.zdelarec.escapecroatioaservices.dto.UserDto;

/**
 * Room service.
 *
 * @author kristijan.zdelarec
 */
public interface UserService {

    /**
     * Method for creating new user Id.
     * @return {@link UserDto} object
     */
    UserDto getNewUserId();

}
