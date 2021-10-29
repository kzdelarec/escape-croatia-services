package hr.tvz.zdelarec.escapecroatioaservices.service.platformUser;

import hr.tvz.zdelarec.escapecroatioaservices.dto.PlatformUserDto;

import java.util.List;

/**
 * Room service.
 *
 * @author kristijan.zdelarec
 */
public interface PlatformUserService {

    /**
     * Method for getting all platform users.
     * @return {@link PlatformUserDto} objects.
     */
    List<PlatformUserDto> getAllUsers();

    /**
     * Method for getting one platform user by identifier.
     * @param id platform user identifier
     * @return {@link PlatformUserDto} object
     */
    PlatformUserDto getById(Long id);

    /**
     * Method for saving a {@link PlatformUserDto} object.
     * @param platformUserDto {@link PlatformUserDto} to be saved
     * @return saved {@link PlatformUserDto} object
     */
    PlatformUserDto save(PlatformUserDto platformUserDto);

}
