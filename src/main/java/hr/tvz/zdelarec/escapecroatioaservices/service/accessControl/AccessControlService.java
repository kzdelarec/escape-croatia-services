package hr.tvz.zdelarec.escapecroatioaservices.service.accessControl;

import hr.tvz.zdelarec.escapecroatioaservices.dto.AccessControlDto;
import hr.tvz.zdelarec.escapecroatioaservices.dto.AuthorityDto;

import java.util.List;

/**
 * Access control service.
 *
 * @author kristijan.zdelarec
 */
public interface AccessControlService {

    /**
     * Method for getting access by user identifier.
     * @param userId user identifier
     * @return {@link AccessControlDto} objects
     */
    List<AccessControlDto> getAccessByUserId(Integer userId);

    /**
     * Method for deleting all access control for user.
     * @param userId userId
     */
    void deleteAllByUserId(Integer userId);

    /**
     * Method for saving multiple {@link AccessControlDto} objects.
     * @param accessControlDtoList {@link AccessControlDto} objects to be saved
     * @param userId user identifier
     * @return saved {@link AuthorityDto} objects
     */
    List<AccessControlDto> saveAll(List<AccessControlDto> accessControlDtoList, Integer userId);

    /**
     * Method for saving  {@link AccessControlDto} object.
     * @param accessControlDto {@link AccessControlDto} object
     * @return saved {@link AuthorityDto} object
     */
    AccessControlDto save(AccessControlDto accessControlDto);

}
