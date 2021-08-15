package hr.tvz.zdelarec.escapecroatioaservices.dto;

import javax.validation.constraints.NotNull;

/**
 * Progress DTO class.
 *
 * @author kristijan.zdelarec
 */
public class ProgressDto {

    /**
     * Progress DTO content type.
     */
    public static final String CONTENT_TYPE = "application/progress.v1+json";

    @NotNull
    private Integer numberOfRooms;
    @NotNull
    private Integer numberOfFinishedRooms;

    public ProgressDto(@NotNull final Integer numberOfRooms, @NotNull final Integer numberOfFinishedRooms) {
        this.numberOfRooms = numberOfRooms;
        this.numberOfFinishedRooms = numberOfFinishedRooms;
    }

    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(final Integer numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public Integer getNumberOfFinishedRooms() {
        return numberOfFinishedRooms;
    }

    public void setNumberOfFinishedRooms(final Integer numberOfFinishedRooms) {
        this.numberOfFinishedRooms = numberOfFinishedRooms;
    }

    @Override
    public String toString() {
        return "ProgressDto{" +
                "numberOfRooms=" + numberOfRooms +
                ", numberOfFinishedRooms=" + numberOfFinishedRooms +
                '}';
    }
}
