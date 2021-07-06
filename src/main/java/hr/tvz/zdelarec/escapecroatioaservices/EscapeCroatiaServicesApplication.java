package hr.tvz.zdelarec.escapecroatioaservices;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Main entry point to the application.
 *
 * @author kristijan.zdelarec
 */
@SpringBootApplication
public class EscapeCroatiaServicesApplication {

    /**
     * Main method for starting the application.
     *
     * @param args passed arguments
     */
    public static void main(final String[] args) {
        SpringApplication.run(EscapeCroatiaServicesApplication.class, args);
    }

    /**
     * Object to Object mapper.
     *
     * @return ModelMapper
     */
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
