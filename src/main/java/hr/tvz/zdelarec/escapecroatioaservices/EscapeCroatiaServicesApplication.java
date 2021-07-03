package hr.tvz.zdelarec.escapecroatioaservices;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EscapeCroatiaServicesApplication {
    public static void main(String[] args) {
        SpringApplication.run(EscapeCroatiaServicesApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
