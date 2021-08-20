package hr.tvz.zdelarec.escapecroatioaservices.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;

/**
 * DeveloperDto class.
 *
 * @author kristijan.zdelarec
 */
public class DeveloperDto {

    /**
     * Developer DTO content type.
     */
    public static final String CONTENT_TYPE = "application/developer.v1+json";

    @NotNull
    @JsonIgnore
    private Integer id;
    private String name;
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "DeveloperDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
