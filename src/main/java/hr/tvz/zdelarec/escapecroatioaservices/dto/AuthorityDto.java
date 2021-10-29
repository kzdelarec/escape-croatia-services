package hr.tvz.zdelarec.escapecroatioaservices.dto;

/**
 * Authority DTO class.
 *
 * @author kristijan.zdelarec
 */

public class AuthorityDto {

    private Integer id;
    private String username;
    private String authority;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(final String authority) {
        this.authority = authority;
    }


    @Override
    public String toString() {
        return "Authority{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", authority='" + authority + '\'' +
                '}';
    }
}