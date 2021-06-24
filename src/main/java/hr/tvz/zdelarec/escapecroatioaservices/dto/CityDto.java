package hr.tvz.zdelarec.escapecroatioaservices.dto;

import javax.validation.constraints.NotNull;

/**
 * CityDto class.
 *
 * @author kristijan.zdelarec
 */
public class CityDto {

    /**
     * City DTO content type.
     */
    public static final String CONTENT_TYPE = "application/city.v1+json";

    @NotNull
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "CityDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
