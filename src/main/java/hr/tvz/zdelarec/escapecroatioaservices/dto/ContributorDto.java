package hr.tvz.zdelarec.escapecroatioaservices.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hr.tvz.zdelarec.escapecroatioaservices.enumeration.ContributionTypeEnum;

import javax.validation.constraints.NotNull;

/**
 * ContributorDto class.
 *
 * @author kristijan.zdelarec
 */
public class ContributorDto {

    /**
     * Contributor DTO content type.
     */
    public static final String CONTENT_TYPE = "application/contributor.v1+json";

    @NotNull
    @JsonIgnore
    private Integer id;
    private String name;
    private String url;
    private ContributionTypeEnum type;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    public ContributionTypeEnum getType() {
        return type;
    }

    public void setType(final ContributionTypeEnum type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ContributorDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", type=" + type +
                '}';
    }
}
