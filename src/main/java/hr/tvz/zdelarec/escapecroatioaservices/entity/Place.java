package hr.tvz.zdelarec.escapecroatioaservices.entity;

import javax.persistence.*;

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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCityId(Integer cityId) {
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
