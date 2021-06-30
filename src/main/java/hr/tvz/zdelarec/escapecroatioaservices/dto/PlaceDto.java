package hr.tvz.zdelarec.escapecroatioaservices.dto;

import javax.validation.constraints.NotNull;

/**
 * PlaceDto class.
 *
 * @author kristijan.zdelarec
 */
public class PlaceDto {

    /**
     * Place DTO content type.
     */
    public static final String CONTENT_TYPE = "application/place.v1+json";

    @NotNull
    private Integer id;
    private String name;
    private String web;
    private String mail;
    private String phone;
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
        return "PlaceDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", web='" + web + '\'' +
                ", mail='" + mail + '\'' +
                ", phone='" + phone + '\'' +
                ", cityId=" + cityId +
                '}';
    }
}
