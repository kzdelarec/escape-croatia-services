package hr.tvz.zdelarec.escapecroatioaservices.entity;

import javax.persistence.*;

/**
 * City entity class.
 *
 * @author kristijan.zdelarec
 */
@Entity
@Table(name = "ec_city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CityDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
