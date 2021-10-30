package hr.tvz.zdelarec.escapecroatioaservices.dto;

/**
 * Confirmation Token DTO class.
 *
 * @author kristijan.zdelarec
 */

public class ConfirmationTokenDto {

    private Integer id;
    private String token;
    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(final String token) {
        this.token = token;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(final Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "ConfirmationTokenDto{" +
                "id=" + id +
                ", token='" + token + '\'' +
                ", userId=" + userId +
                '}';
    }
}