package hr.tvz.zdelarec.escapecroatioaservices.dto;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Finished room DTO class.
 *
 * @author kristijan.zdelarec
 */
public class FinishedRoomDto {

    /**
     * Finished room DTO content type.
     */
    public static final String CONTENT_TYPE = "application/finished_room.v1+json";

    @Id
    private Integer id;
    @NotNull
    private Integer cityId;
    @NotNull
    private Integer placeId;
    @NotNull
    private Integer roomId;
    @NotNull
    private String userId;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(final Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getPlaceId() {
        return placeId;
    }

    public void setPlaceId(final Integer placeId) {
        this.placeId = placeId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(final Integer roomId) {
        this.roomId = roomId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "FinishedRoomDto{" +
                "id=" + id +
                ", cityId=" + cityId +
                ", placeId=" + placeId +
                ", roomId=" + roomId +
                ", userId='" + userId + '\'' +
                '}';
    }
}
