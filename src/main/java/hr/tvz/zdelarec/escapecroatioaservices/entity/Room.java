package hr.tvz.zdelarec.escapecroatioaservices.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Room entity class.
 *
 * @author kristijan.zdelarec
 */
@Entity
@Table(name = "ec_room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String address;
    private String players;
    private Integer time;
    private String reservationUrl;
    private Boolean isActive;
    @Column(name = "place_id")
    private Integer placeId;
    @Column(name = "city_id")
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

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(final Integer cityId) {
        this.cityId = cityId;
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

    public Integer getPlaceId() {
        return placeId;
    }

    public void setPlaceId(final Integer placeId) {
        this.placeId = placeId;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", players='" + players + '\'' +
                ", time=" + time +
                ", reservationUrl='" + reservationUrl + '\'' +
                ", isActive=" + isActive +
                ", placeId=" + placeId +
                ", cityId=" + cityId +
                '}';
    }
}
