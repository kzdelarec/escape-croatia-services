package hr.tvz.zdelarec.escapecroatioaservices.api.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Application test ping controller.
 *
 * @author kristijan.zdelarec
 */
@RestController
@RequestMapping(path = "/api/ping", produces = "application/json")
@CrossOrigin
public class PingController {

    /**
     * Ping test method that returns status of the service.
     *
     * @return status of service
     */
    @GetMapping
    public String returnPing() {
        return "Service is alive";
    }
}
