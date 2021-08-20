package hr.tvz.zdelarec.escapecroatioaservices.service.information;

import hr.tvz.zdelarec.escapecroatioaservices.dto.InformationDto;

/**
 * Information service.
 *
 * @author kristijan.zdelarec
 */
public interface InformationService {

    /**
     * Method for fetching {@link InformationDto} object.
     * @return {@link InformationDto} object
     */
    InformationDto getInformation();
}
