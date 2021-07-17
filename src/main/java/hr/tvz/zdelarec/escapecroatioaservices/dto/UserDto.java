package hr.tvz.zdelarec.escapecroatioaservices.dto;

import javax.validation.constraints.NotNull;

/**
 * User DTO class.
 *
 * @author kristijan.zdelarec
 */
public class UserDto {

    /**
     * User DTO content type.
     */
    public static final String CONTENT_TYPE = "application/user.v1+json";

    @NotNull
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
