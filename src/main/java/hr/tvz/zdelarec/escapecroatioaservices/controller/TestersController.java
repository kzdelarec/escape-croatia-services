package hr.tvz.zdelarec.escapecroatioaservices.controller;

import hr.tvz.zdelarec.escapecroatioaservices.dto.CityDto;
import hr.tvz.zdelarec.escapecroatioaservices.dto.TesterDto;
import hr.tvz.zdelarec.escapecroatioaservices.entity.Tester;
import hr.tvz.zdelarec.escapecroatioaservices.repository.TesterRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
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
 * Contains mappings related to the testers page.
 *
 * @author kristijan.zdelarec
 */
@Controller
@RequestMapping(value = {"/testers"})
public class TestersController {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TestersController.class);

    /**
     * Autowired {@link TesterRepository}.
     */
    @Autowired
    private TesterRepository testerRepository;

    /**
     * Autowired {@link ModelMapper}.
     */
    @Autowired
    private ModelMapper modelMapper;

    /**
     * Get testers view page.
     *
     * @param model view model
     * @return view name
     */
    @GetMapping
    @Secured("ROLE_ADMIN")
    public String showTesters(final Model model) {
        LOGGER.debug("Showing testers page");
        final List<TesterDto> testers = testerRepository.findAll().stream().map(tester -> modelMapper.map(tester, TesterDto.class)).collect(Collectors.toList());
        model.addAttribute("testers", testers);
        return "testers";
    }

    /**
     * Show page for creating a new tester.
     * @param model view model
     * @return view name
     */
    @GetMapping(path = "/new")
    public String newTester(final Model model) {
        model.addAttribute(new TesterDto());
        return "newTester";
    }

    /**
     * Redirect for saving and displaying testers page.
     * @param testerDto {@link TesterDto} object
     * @param model view model
     * @return view name
     */
    @PostMapping(path = "/save")
    public String saveTester(@Validated final TesterDto testerDto, final Model model) {
        testerRepository.save(modelMapper.map(testerDto, Tester.class));
        return "redirect:/testers";
    }

    /**
     * Show page for editing a new tester.
     * @param model view model
     * @param id {@link TesterDto} identifier
     * @return view name
     */
    @GetMapping(path = "/edit/{id}")
    public String editTester(final Model model, @PathVariable("id") final Integer id) {
        model.addAttribute(modelMapper.map(testerRepository.findById(id).orElseThrow(), TesterDto.class));
        return "newTester";
    }

    /**
     * Redirect for deleting and displaying cities page.
     * @param id {@link CityDto} identifier
     * @param model view model
     * @return view name
     */
    @GetMapping(path = "/delete/{id}")
    public String deleteTester(final Model model, @PathVariable("id") final Integer id) {
        testerRepository.delete(testerRepository.findById(id).orElseThrow());
        return "redirect:/testers";
    }
}
