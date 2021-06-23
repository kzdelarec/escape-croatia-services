package hr.tvz.zdelarec.escapecroatioaservices.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path="/ping", produces="application/json")
@CrossOrigin
public class Ping {
    @GetMapping
    public String returnPing(){
        return "Service is alive";
    }
}
