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
    private Integer progress;
    private Integer numberOfRooms;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(final Integer progress) {
        this.progress = progress;
    }

    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(final Integer numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CityDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", progress=" + progress +
                ", numberOfRooms=" + numberOfRooms +
                '}';
    }
}
