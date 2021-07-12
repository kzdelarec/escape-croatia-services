package hr.tvz.zdelarec.escapecroatioaservices.dto;

import javax.validation.constraints.NotNull;

/**
 * RoomDto class.
 *
 * @author kristijan.zdelarec
 */
public class RoomDto {

    /**
     * Room DTO content type.
     */
    public static final String CONTENT_TYPE = "application/room.v1+json";

    @NotNull
    private Integer id;
    private String name;
    private String address;
    private String players;
    private Integer time;
    private String reservationUrl;
    private Boolean isActive;
    private Boolean isFinished;
    private Integer placeId;
    private Integer cityId;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public String getPlayers() {
        return players;
    }

    public void setPlayers(final String players) {
        this.players = players;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(final Integer time) {
        this.time = time;
    }

    public String getReservationUrl() {
        return reservationUrl;
    }

    public void setReservationUrl(final String reservationUrl) {
        this.reservationUrl = reservationUrl;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(final Boolean active) {
        isActive = active;
    }

    public Boolean getFinished() {
        return isFinished;
    }

    public void setFinished(final Boolean finished) {
        isFinished = finished;
    }

    public Integer getPlaceId() {
        return placeId;
    }

    public void setPlaceId(final Integer placeId) {
        this.placeId = placeId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(final Integer cityId) {
        this.cityId = cityId;
    }

    @Override
    public String toString() {
        return "RoomDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", players='" + players + '\'' +
                ", time=" + time +
                ", reservationUrl='" + reservationUrl + '\'' +
                ", isActive=" + isActive +
                ", isFinished=" + isFinished +
                ", placeId=" + placeId +
                ", cityId=" + cityId +
                '}';
    }
}
