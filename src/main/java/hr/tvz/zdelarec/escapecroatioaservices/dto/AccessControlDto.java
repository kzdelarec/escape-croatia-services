package hr.tvz.zdelarec.escapecroatioaservices.dto;

import javax.validation.constraints.NotNull;

/**
 * Access Control DTO class.
 *
 * @author kristijan.zdelarec
 */

public class AccessControlDto {

    private Integer id;
    @NotNull
    private Integer placeId;
    @NotNull
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
        return "AccessControlDto{" +
                "id=" + id +
                ", placeId=" + placeId +
                ", userId=" + userId +
                '}';
    }
}