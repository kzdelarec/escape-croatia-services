package hr.tvz.zdelarec.escapecroatioaservices.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Contains mappings related to the home/index page.
 *
 * @author kristijan.zdelarec
 */
@Controller
@RequestMapping(value = {"/", "/index"})
public class IndexController {
    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    /**
     * Get index view page.
     * @return view name
     */
    @GetMapping
    public String showIndex() {
        LOGGER.debug("Showing index page");
        return "index";
    }
}
