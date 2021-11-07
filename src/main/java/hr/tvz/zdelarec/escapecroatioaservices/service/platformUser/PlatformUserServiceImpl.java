package hr.tvz.zdelarec.escapecroatioaservices.service.platformUser;

import hr.tvz.zdelarec.escapecroatioaservices.dto.PlatformUserDto;
import hr.tvz.zdelarec.escapecroatioaservices.entity.PlatformUser;
import hr.tvz.zdelarec.escapecroatioaservices.repository.PlatformUserRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * {@link PlatformUserService} implementation.
 *
 * @author kristijan.zdelarec
 */
@Service
public class PlatformUserServiceImpl implements PlatformUserService {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PlatformUserService.class);

    /**
     * Autowired {@link PlatformUserRepository}.
     */
    @Autowired
    private PlatformUserRepository platformUserRepository;

    /**
     * Autowired {@link ModelMapper}.
     */
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<PlatformUserDto> getAllUsers() {
        return platformUserRepository.findAll().stream().map(platformUser -> modelMapper.map(platformUser, PlatformUserDto.class)).collect(Collectors.toList());
    }

    @Override
    public PlatformUserDto getById(final Long id) {
        return modelMapper.map(platformUserRepository.findById(id).orElseThrow(), PlatformUserDto.class);
    }

    @Override
    public PlatformUserDto save(final PlatformUserDto platformUserDto) {
        return modelMapper.map(platformUserRepository.save(modelMapper.map(platformUserDto, PlatformUser.class)), PlatformUserDto.class);
    }

    @Override
    public PlatformUserDto getByUsername(final String username) {
        return modelMapper.map(platformUserRepository.findByUsername(username), PlatformUserDto.class);
    }
}
