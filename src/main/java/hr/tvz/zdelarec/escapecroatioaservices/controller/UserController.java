package hr.tvz.zdelarec.escapecroatioaservices.controller;

import hr.tvz.zdelarec.escapecroatioaservices.dto.UserDto;
import hr.tvz.zdelarec.escapecroatioaservices.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for User CRUD operations.
 *
 * @author kristijan.zdelarec
 */
@RestController
@RequestMapping(path = UserController.BASE_URL)
@CrossOrigin
public class UserController {

    /**
     * Base URL for User controller.
     */
    public static final String BASE_URL = "/user";

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    /**
     * Autowired {@link UserService}.
     */
    @Autowired
    private UserService userService;

    /**
     * Endpoint for creating new {@link UserDto}.
     *
     * @return created {@link UserDto} object
     */
    @GetMapping(produces = UserDto.CONTENT_TYPE)
    public UserDto getUserId() {
        LOGGER.info("Fetching new user ID...");
        return userService.getNewUserId();
    }

}
