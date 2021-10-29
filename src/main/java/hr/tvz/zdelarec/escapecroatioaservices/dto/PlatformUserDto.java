package hr.tvz.zdelarec.escapecroatioaservices.dto;


import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Platform user DTO class.
 *
 * @author kristijan.zdelarec
 */

public class PlatformUserDto {

    @NotNull
    private Long id;
    @NotNull
    private String username;
    private String password;
    @NotNull
    private Boolean enabled;

    private List<String> authorities;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(final Boolean enabled) {
        this.enabled = enabled;
    }

    public List<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(final List<String> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String toString() {
        return "PlatformUserDto{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", authorities=" + authorities +
                '}';
    }
}
