package hr.tvz.zdelarec.escapecroatioaservices.dto;


import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Favorite DTO class.
 *
 * @author kristijan.zdelarec
 */
public class FavoriteDto {

    /**
     * Favorite DTO content type.
     */
    public static final String CONTENT_TYPE = "application/favorites.v1+json";

    @Id
    private Integer id;
    @NotNull
    private Integer placeId;
    @NotNull
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
        return "FavoriteDto{" +
                "id=" + id +
                ", placeId=" + placeId +
                ", userId='" + userId + '\'' +
                '}';
    }
}
