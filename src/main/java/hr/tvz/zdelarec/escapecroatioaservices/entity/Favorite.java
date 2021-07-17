package hr.tvz.zdelarec.escapecroatioaservices.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Favorite entity class.
 *
 * @author kristijan.zdelarec
 */
@Entity
@Table(name = "ec_favorites")
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer placeId;
    private String userId;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Favorite{" +
                "id=" + id +
                ", placeId=" + placeId +
                ", userId='" + userId + '\'' +
                '}';
    }
}
