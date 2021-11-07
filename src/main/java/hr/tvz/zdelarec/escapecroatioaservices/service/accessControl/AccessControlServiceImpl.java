package hr.tvz.zdelarec.escapecroatioaservices.service.accessControl;

import hr.tvz.zdelarec.escapecroatioaservices.dto.AccessControlDto;
import hr.tvz.zdelarec.escapecroatioaservices.entity.AccessControl;
import hr.tvz.zdelarec.escapecroatioaservices.repository.AccessControlRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * {@link AccessControlService} implementation.
 *
 * @author kristijan.zdelarec
 */
@Service
public class AccessControlServiceImpl implements AccessControlService {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(AccessControl.class);

    /**
     * Autowired {@link AccessControlRepository}.
     */
    @Autowired
    private AccessControlRepository accessControlRepository;

    /**
     * Autowired {@link ModelMapper}.
     */
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<AccessControlDto> getAccessByUserId(final Integer userId) {
        return accessControlRepository.findAllByUserId(userId).stream().map(accessControl -> modelMapper.map(accessControl, AccessControlDto.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteAllByUserId(final Integer userId) {
        accessControlRepository.deleteByUserId(userId);
    }

    @Override
    public List<AccessControlDto> saveAll(final List<AccessControlDto> accessControlDtoList, final Integer userId) {
        return checkAndUpdateAuthorities(accessControlDtoList, userId);
    }

    @Override
    public AccessControlDto save(final AccessControlDto accessControlDto) {
        return modelMapper.map(accessControlRepository.save(modelMapper.map(accessControlDto, AccessControl.class)), AccessControlDto.class);
    }

    private List<AccessControlDto> checkAndUpdateAuthorities(final List<AccessControlDto> accessControlDtoList, final Integer userId) {
        if (accessControlDtoList.isEmpty()) {
            deleteAllByUserId(userId);
        } else {
            final List<AccessControlDto> originalAccess = getAccessByUserId(userId);
            final List<Integer> newAccessIds = accessControlDtoList.stream().map(AccessControlDto::getPlaceId).collect(Collectors.toList());
            final List<Integer> originalAccessIds = originalAccess.stream().map(AccessControlDto::getPlaceId).collect(Collectors.toList());
            final List<AccessControlDto> authoritiesToRemove = originalAccess.stream()
                    .filter(accessControlDto -> !newAccessIds.contains(accessControlDto.getPlaceId()))
                    .collect(Collectors.toList());

            final List<AccessControlDto> authoritiesToAdd = accessControlDtoList.stream()
                    .filter(accessControlDto -> !originalAccessIds.contains(accessControlDto.getPlaceId()))
                    .collect(Collectors.toList());

            accessControlRepository.deleteAll(authoritiesToRemove.stream().map(authorityDto -> modelMapper.map(authorityDto, AccessControl.class)).collect(Collectors.toList()));
            accessControlRepository.saveAll(authoritiesToAdd.stream().map(authorityDto -> modelMapper.map(authorityDto, AccessControl.class)).collect(Collectors.toList()));
        }
        return accessControlDtoList;
    }
}
