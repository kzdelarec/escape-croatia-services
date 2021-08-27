package hr.tvz.zdelarec.escapecroatioaservices.api.controller;

import hr.tvz.zdelarec.escapecroatioaservices.dto.CityDto;
import hr.tvz.zdelarec.escapecroatioaservices.dto.InformationDto;
import hr.tvz.zdelarec.escapecroatioaservices.service.information.InformationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for Information CRUD operations.
 *
 * @author kristijan.zdelarec
 */
@RestController
@RequestMapping(path = InformationController.BASE_URL)
@CrossOrigin
public class InformationController {

    /**
     * Base URL for Information controller.
     */
    public static final String BASE_URL = "/api/information";

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(InformationController.class);

    /**
     * Autowired {@link InformationService}.
     */
    @Autowired
    private InformationService informationService;

    /**
     * Endpoint for fetching {@link InformationDto} object.
     * @return fetched {@link InformationDto} object
     */
    @GetMapping(produces = CityDto.CONTENT_TYPE)
    public InformationDto getAll() {
        LOGGER.info("Fetching information..");
        return informationService.getInformation();
    }

}
