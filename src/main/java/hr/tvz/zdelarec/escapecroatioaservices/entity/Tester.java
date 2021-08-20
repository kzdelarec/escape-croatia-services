package hr.tvz.zdelarec.escapecroatioaservices.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tester entity class.
 *
 * @author kristijan.zdelarec
 */
@Entity
@Table(name = "ec_tester")
public class Tester {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
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
        return "Tester{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
