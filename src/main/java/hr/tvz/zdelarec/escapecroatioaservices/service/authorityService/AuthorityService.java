package hr.tvz.zdelarec.escapecroatioaservices.service.authorityService;

import hr.tvz.zdelarec.escapecroatioaservices.dto.AuthorityDto;

import java.util.List;

/**
 * Authority service.
 *
 * @author kristijan.zdelarec
 */
public interface AuthorityService {

    /**
     * Method for getting authorities by username.
     * @param username username
     * @return {@link AuthorityDto} objects
     */
    List<AuthorityDto> getPermissionByUsername(String username);

    /**
     * Method for deleting all authorities for username.
     * @param username username
     */
    void deleteAllByUsername(String username);

    /**
     * Method for saving a {@link AuthorityDto} object.
     * @param authorityDto {@link AuthorityDto} object to be saved
     * @return saved {@link AuthorityDto} object
     */
    AuthorityDto save(AuthorityDto authorityDto);

}
