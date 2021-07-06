package hr.tvz.zdelarec.escapecroatioaservices.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Place entity class.
 *
 * @author kristijan.zdelarec
 */
@Entity
@Table(name = "ec_place")
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String web;
    private String mail;
    private String phone;
    @Column(name = "city_id")
    private Integer cityId;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getWeb() {
        return web;
    }

    public String getMail() {
        return mail;
    }

    public String getPhone() {
        return phone;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setWeb(final String web) {
        this.web = web;
    }

    public void setMail(final String mail) {
        this.mail = mail;
    }

    public void setPhone(final String phone) {
        this.phone = phone;
    }

    public void setCityId(final Integer cityId) {
        this.cityId = cityId;
    }

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", web='" + web + '\'' +
                ", mail='" + mail + '\'' +
                ", phone='" + phone + '\'' +
                ", cityId=" + cityId +
                '}';
    }
}
