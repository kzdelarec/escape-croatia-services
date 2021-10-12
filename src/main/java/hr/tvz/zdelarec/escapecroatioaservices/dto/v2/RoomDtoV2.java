package hr.tvz.zdelarec.escapecroatioaservices.dto.v2;

import hr.tvz.zdelarec.escapecroatioaservices.enumeration.RoomStatusEnum;

import javax.validation.constraints.NotNull;

/**
 * RoomDtoV2 class.
 *
 * @author kristijan.zdelarec
 */
public class RoomDtoV2 {

    /**
     * Room DTO V2 content type.
     */
    public static final String CONTENT_TYPE = "application/room.v2+json";


    private Integer id;
    @NotNull
    private String name;
    @NotNull
    private String nameLocal;
    @NotNull
    private String address;
    @NotNull
    private String players;
    @NotNull
    private Integer time;
    private String reservationUrl;
    @NotNull
    private Boolean isActive;
    private RoomStatusEnum roomStatus;
    @NotNull
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

    public String getNameLocal() {
        return nameLocal;
    }

    public void setNameLocal(final String nameLocal) {
        this.nameLocal = nameLocal;
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

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(final Boolean active) {
        isActive = active;
    }

    public RoomStatusEnum getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(final RoomStatusEnum roomStatus) {
        this.roomStatus = roomStatus;
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
                ", nameLocal='" + nameLocal + '\'' +
                ", address='" + address + '\'' +
                ", players='" + players + '\'' +
                ", time=" + time +
                ", reservationUrl='" + reservationUrl + '\'' +
                ", isActive=" + isActive +
                ", roomStatus=" + roomStatus +
                ", placeId=" + placeId +
                ", cityId=" + cityId +
                '}';
    }
}
