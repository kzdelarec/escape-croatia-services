package hr.tvz.zdelarec.escapecroatioaservices.dto;

import javax.validation.constraints.NotNull;

/**
 * RoomeDto class.
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
    private Integer placeId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPlayers() {
        return players;
    }

    public void setPlayers(String players) {
        this.players = players;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String getReservationUrl() {
        return reservationUrl;
    }

    public void setReservationUrl(String reservationUrl) {
        this.reservationUrl = reservationUrl;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Integer getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Integer placeId) {
        this.placeId = placeId;
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
                ", placeId=" + placeId +
                '}';
    }
}
