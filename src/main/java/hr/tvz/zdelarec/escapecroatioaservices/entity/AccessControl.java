package hr.tvz.zdelarec.escapecroatioaservices.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Access Control entity class.
 *
 * @author kristijan.zdelarec
 */
@Entity
@Table(name = "access_control")
public class AccessControl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer placeId;
    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public Integer getPlaceId() {
        return placeId;
    }

    public void setPlaceId(final Integer placeId) {
        this.placeId = placeId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(final Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "AccessControl{" +
                "id=" + id +
                ", placeId=" + placeId +
                ", userId=" + userId +
                '}';
    }
}