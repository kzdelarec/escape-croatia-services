package hr.tvz.zdelarec.escapecroatioaservices.dto;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User DTO class.
 *
 * @author kristijan.zdelarec
 */
@Entity
@Table(name = "ec_user")
public class UserDto {

    /**
     * User DTO content type.
     */
    public static final String CONTENT_TYPE = "application/user.v1+json";

    @Id
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                '}';
    }
}
