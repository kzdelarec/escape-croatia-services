package hr.tvz.zdelarec.escapecroatioaservices.dto;

import hr.tvz.zdelarec.escapecroatioaservices.enumeration.RoomStatusEnum;

import javax.validation.constraints.NotNull;

/**
 * RoomDetailsDto class.
 *
 * @author kristijan.zdelarec
 */
public class RoomDetailsDto {

    /**
     * RoomDetails DTO content type.
     */
    public static final String CONTENT_TYPE = "application/roomDetails.v1+json";

    private Integer id;
    private Integer rating;
    private String time;
    private Integer hints;
    private Integer numberOfPlayers;
    private String imageId;
    private RoomStatusEnum roomStatus;
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

    public Integer getRating() {
        return rating;
    }

    public void setRating(final Integer rating) {
        this.rating = rating;
    }

    public String getTime() {
        return time;
    }

    public void setTime(final String time) {
        this.time = time;
    }

    public Integer getHints() {
        return hints;
    }

    public void setHints(final Integer hints) {
        this.hints = hints;
    }

    public Integer getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(final Integer numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(final String imageId) {
        this.imageId = imageId;
    }

    public RoomStatusEnum getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(final RoomStatusEnum roomStatus) {
        this.roomStatus = roomStatus;
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
        return "RoomDetailsDto{" +
                "id=" + id +
                ", rating=" + rating +
                ", time='" + time + '\'' +
                ", hints=" + hints +
                ", numberOfPlayers=" + numberOfPlayers +
                ", imageId='" + imageId + '\'' +
                ", roomStatus=" + roomStatus +
                ", roomId=" + roomId +
                ", userId='" + userId + '\'' +
                '}';
    }
}
