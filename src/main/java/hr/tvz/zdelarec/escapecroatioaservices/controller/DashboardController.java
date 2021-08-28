package hr.tvz.zdelarec.escapecroatioaservices.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Contains mappings related to the dashboard page.
 *
 * @author kristijan.zdelarec
 */
@Controller
@RequestMapping(value = {"dashboard"})
public class DashboardController {
    private static final Logger LOGGER = LoggerFactory.getLogger(DashboardController.class);

    /**
     * Get index view page.
     * @return view name
     */
    @GetMapping
    @PreAuthorize("hasRole(T(hr.tvz.zdelarec.escapecroatioaservices.enumeration.Permission).ROLE_ADMIN.toString())" +
            "or hasRole(T(hr.tvz.zdelarec.escapecroatioaservices.enumeration.Permission).ROLE_CONTRIBUTOR.toString())"
    )
    public String showIndex() {
        LOGGER.debug("Showing dashboard page");
        return "dashboard";
    }
}
