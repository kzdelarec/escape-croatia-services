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

    private Integer id;
    @NotNull
    private String name;
    private ProgressDto progress;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public ProgressDto getProgress() {
        return progress;
    }

    public void setProgress(final ProgressDto progress) {
        this.progress = progress;
    }

    @Override
    public String toString() {
        return "CityDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", progress=" + progress +
                '}';
    }
}
