package hr.tvz.zdelarec.escapecroatioaservices.entity;


import hr.tvz.zdelarec.escapecroatioaservices.enumeration.ContributionTypeEnum;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Contributor entity class.
 *
 * @author kristijan.zdelarec
 */
@Entity
@Table(name = "ec_contributor")
public class Contributor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String url;
    @Enumerated(EnumType.STRING)
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
        return "Contributor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", type=" + type.getValue() +
                '}';
    }
}
