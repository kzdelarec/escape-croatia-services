package hr.tvz.zdelarec.escapecroatioaservices.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;

/**
 * TesterDto class.
 *
 * @author kristijan.zdelarec
 */
public class TesterDto {

    /**
     * Tester DTO content type.
     */
    public static final String CONTENT_TYPE = "application/tester.v1+json";

    @JsonIgnore
    private Integer id;
    @NotNull
    private String name;

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

    @Override
    public String toString() {
        return "TesterDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
