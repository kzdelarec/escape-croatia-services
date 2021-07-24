package hr.tvz.zdelarec.escapecroatioaservices.service.user;

import hr.tvz.zdelarec.escapecroatioaservices.dto.UserDto;
import hr.tvz.zdelarec.escapecroatioaservices.entity.User;
import hr.tvz.zdelarec.escapecroatioaservices.repository.RoomRepository;
import hr.tvz.zdelarec.escapecroatioaservices.repository.UserRepository;
import hr.tvz.zdelarec.escapecroatioaservices.service.room.RoomService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * {@link RoomService} implementation.
 *
 * @author kristijan.zdelarec
 */
@Service
public class UserServiceImpl implements UserService {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    /**
     * Autowired {@link RoomRepository}.
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * Autowired {@link ModelMapper}.
     */
    @Autowired
    private ModelMapper modelMapper;

    /**
     * Check if user Id exists.
     * @param userId user identifier
     * @return {@link Boolean}
     */
    private Boolean existsByUserId(final String userId) {
        return userRepository.existsByUserId(userId);
    }

    @Override
    public UserDto getNewUserId() {
        final String userId = UUID.randomUUID().toString();
        if (existsByUserId(userId)) {
            LOGGER.info("User ID {} already exists. Fetching new one.", userId);
            return getNewUserId();
        } else {
            final User user = new User();
            user.setUserId(userId);
            userRepository.save(user);
            LOGGER.info("Created new user with ID {}", userId);
            return modelMapper.map(user, UserDto.class);
        }
    }
}
