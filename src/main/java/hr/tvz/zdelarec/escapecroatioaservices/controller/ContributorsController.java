package hr.tvz.zdelarec.escapecroatioaservices.controller;

import hr.tvz.zdelarec.escapecroatioaservices.dto.ContributorDto;
import hr.tvz.zdelarec.escapecroatioaservices.dto.PlaceDto;
import hr.tvz.zdelarec.escapecroatioaservices.entity.Contributor;
import hr.tvz.zdelarec.escapecroatioaservices.enumeration.ContributionTypeEnum;
import hr.tvz.zdelarec.escapecroatioaservices.repository.ContributorRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Contains mappings related to the contributors page.
 *
 * @author kristijan.zdelarec
 */
@Controller
@RequestMapping(value = {"/contributors"})
public class ContributorsController {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ContributorsController.class);

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

    /**
     * Get contributors view page.
     *
     * @param model view model
     * @return view name
     */
    @GetMapping
    public String showContributors(final Model model) {
        LOGGER.debug("Showing contributors page");
        final List<ContributorDto> contributorDtoList = contributorRepository.findAll().stream().map(contributor -> modelMapper.map(contributor, ContributorDto.class)).collect(Collectors.toList());
        model.addAttribute("contributors", contributorDtoList);
        return "contributors";
    }

    /**
     * Show page for creating a new contributor.
     * @param model view model
     * @return view name
     */
    @GetMapping(path = "/new")
    public String newContributor(final Model model) {
        model.addAttribute("contributorDto", new ContributorDto());
        model.addAttribute("types", ContributionTypeEnum.values());
        return "newContributor";
    }

    /**
     * Redirect for saving and displaying contributors page.
     * @param contributorDto {@link ContributorDto} object
     * @param model view model
     * @return view name
     */
    @PostMapping(path = "/save")
    public String saveContributor(@Validated final ContributorDto contributorDto, final Model model) {
        contributorRepository.save(modelMapper.map(contributorDto, Contributor.class));
        return "redirect:/contributors";
    }

    /**
     * Show page for editing a new contributor.
     * @param model view model
     * @param id {@link ContributorDto} identifier
     * @return view name
     */
    @GetMapping(path = "/edit/{id}")
    public String editContributors(final Model model, @PathVariable("id") final Integer id) {
        model.addAttribute(modelMapper.map(contributorRepository.findById(id).orElseThrow(), ContributorDto.class));
        model.addAttribute("types", ContributionTypeEnum.values());
        return "newContributor";
    }

    /**
     * Redirect for deleting and displaying contributors page.
     * @param id {@link PlaceDto} identifier
     * @param model view model
     * @return view name
     */
    @GetMapping(path = "/delete/{id}")
    public String deleteContributor(final Model model, @PathVariable("id") final Integer id) {
        contributorRepository.delete(contributorRepository.findById(id).orElseThrow());
        return "redirect:/contributors";
    }
}
