package hr.tvz.zdelarec.escapecroatioaservices.service.information;

import hr.tvz.zdelarec.escapecroatioaservices.dto.ContributorDto;
import hr.tvz.zdelarec.escapecroatioaservices.dto.DeveloperDto;
import hr.tvz.zdelarec.escapecroatioaservices.dto.InformationDto;
import hr.tvz.zdelarec.escapecroatioaservices.dto.TesterDto;
import hr.tvz.zdelarec.escapecroatioaservices.repository.ContributorRepository;
import hr.tvz.zdelarec.escapecroatioaservices.repository.DeveloperRepository;
import hr.tvz.zdelarec.escapecroatioaservices.repository.TesterRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

/**
 *  {@link InformationService} implementation.
 *
 * @author kristijan.zdelarec
 */
@Service
public class InformationServiceImpl implements InformationService {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(InformationService.class);

    /**
     * Autowired {@link DeveloperRepository}.
     */
    @Autowired
    private DeveloperRepository developerRepository;

    /**
     * Autowired {@link TesterRepository}.
     */
    @Autowired
    private TesterRepository testerRepository;

    /**
     * Autowired {@link ContributorRepository}.
     */
    @Autowired
    private ContributorRepository contributorRepository;

    /**
     * Autowired {@link ModelMapper}.
     */
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public InformationDto getInformation() {
        final InformationDto informationDto = new InformationDto();
        informationDto.setDeveloperDtoList(developerRepository.findAll().stream().map(developer -> modelMapper.map(developer, DeveloperDto.class)).collect(Collectors.toList()));
        informationDto.setTesterDtoList(testerRepository.findAll().stream().map(tester -> modelMapper.map(tester, TesterDto.class)).collect(Collectors.toList()));
        informationDto.setContributorDtoList(contributorRepository.findAll().stream().map(contributor -> modelMapper.map(contributor, ContributorDto.class)).collect(Collectors.toList()));
        return informationDto;
    }
}
