package hr.tvz.zdelarec.escapecroatioaservices.service.authorityService;

import hr.tvz.zdelarec.escapecroatioaservices.dto.AuthorityDto;
import hr.tvz.zdelarec.escapecroatioaservices.entity.Authority;
import hr.tvz.zdelarec.escapecroatioaservices.repository.AuthorityRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * {@link AuthorityService} implementation.
 *
 * @author kristijan.zdelarec
 */
@Service
public class AuthorityServiceImpl implements AuthorityService {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorityService.class);

    /**
     * Autowired {@link AuthorityRepository}.
     */
    @Autowired
    private AuthorityRepository authorityRepository;

    /**
     * Autowired {@link ModelMapper}.
     */
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<AuthorityDto> getPermissionByUsername(final String username) {
        return authorityRepository.findAllDistinctByUsername(username).stream().map(authority -> modelMapper.map(authority, AuthorityDto.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteAllByUsername(final String username) {
        authorityRepository.deleteByUsername(username);
    }

    @Override
    public AuthorityDto save(final AuthorityDto authorityDto) {
        return modelMapper.map(authorityRepository.save(modelMapper.map(authorityDto, Authority.class)), AuthorityDto.class);
    }

    @Override
    public List<AuthorityDto> saveAll(final List<AuthorityDto> authorityDtoList, final String username) {
        return checkAndUpdateAuthorities(authorityDtoList, username);
    }

    private List<AuthorityDto> checkAndUpdateAuthorities(final List<AuthorityDto> authorityDtoList, final String username) {
        if (authorityDtoList.isEmpty()) {
            deleteAllByUsername(username);
        } else {
            final List<AuthorityDto> originalAuthorities = getPermissionByUsername(username);
            final List<String> newAuthorityNames = authorityDtoList.stream().map(AuthorityDto::getAuthority).collect(Collectors.toList());
            final List<String> originalAuthorityNames = originalAuthorities.stream().map(AuthorityDto::getAuthority).collect(Collectors.toList());
            final List<AuthorityDto> authoritiesToRemove = originalAuthorities.stream()
                    .filter(authorityDto -> !newAuthorityNames.contains(authorityDto.getAuthority()))
                    .collect(Collectors.toList());

            final List<AuthorityDto> authoritiesToAdd = authorityDtoList.stream()
                    .filter(authorityDto -> !originalAuthorityNames.contains(authorityDto.getAuthority()))
                    .collect(Collectors.toList());

            authorityRepository.deleteAll(authoritiesToRemove.stream().map(authorityDto -> modelMapper.map(authorityDto, Authority.class)).collect(Collectors.toList()));
            authorityRepository.saveAll(authoritiesToAdd.stream().map(authorityDto -> modelMapper.map(authorityDto, Authority.class)).collect(Collectors.toList()));
        }
        return authorityDtoList;
    }
}
