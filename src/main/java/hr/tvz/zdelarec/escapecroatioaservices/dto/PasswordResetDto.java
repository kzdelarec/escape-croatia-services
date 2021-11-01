package hr.tvz.zdelarec.escapecroatioaservices.dto;

import javax.validation.constraints.NotNull;

/**
 * Password Reset DTO class.
 *
 * @author kristijan.zdelarec
 */
public class PasswordResetDto {

    @NotNull
    private String password;
    @NotNull
    private String passwordConfirm;
    @NotNull
    private String token;

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(final String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public String getToken() {
        return token;
    }

    public void setToken(final String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "PasswordResetDto{" +
                "password='" + password + '\'' +
                ", passwordConfirm='" + passwordConfirm + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
