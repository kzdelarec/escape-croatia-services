package hr.tvz.zdelarec.escapecroatioaservices.service.confirmationTokenService;

import hr.tvz.zdelarec.escapecroatioaservices.dto.ConfirmationTokenDto;
import hr.tvz.zdelarec.escapecroatioaservices.entity.ConfirmationToken;
import hr.tvz.zdelarec.escapecroatioaservices.repository.ConfirmationTokenRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * {@link ConfirmationTokenService} implementation.
 *
 * @author kristijan.zdelarec
 */
@Service
public class ConfirmationTokenServiceImpl implements ConfirmationTokenService {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ConfirmationTokenService.class);

    /**
     * Autowired {@link ConfirmationTokenRepository}.
     */
    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;

    /**
     * Autowired {@link ModelMapper}.
     */
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public ConfirmationTokenDto getByToken(final String token) {
        return modelMapper.map(confirmationTokenRepository.findOneByToken(token), ConfirmationTokenDto.class);
    }

    @Override
    public void deleteByToken(final String token) {
        confirmationTokenRepository.deleteOneByToken(token);
    }

    @Override
    public ConfirmationTokenDto save(final ConfirmationTokenDto confirmationTokenDto) {
        return modelMapper.map(confirmationTokenRepository.save(modelMapper.map(confirmationTokenDto, ConfirmationToken.class)), ConfirmationTokenDto.class);
    }
}
