package hr.tvz.zdelarec.escapecroatioaservices.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User entity class.
 *
 * @author kristijan.zdelarec
 */
@Entity
@Table(name = "ec_user")
public class User {

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
