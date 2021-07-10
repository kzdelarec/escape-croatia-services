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
    private Boolean favorite;
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

    public Boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
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
        return "PlaceDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", web='" + web + '\'' +
                ", mail='" + mail + '\'' +
                ", phone='" + phone + '\'' +
                ", favourite='" + favorite + '\'' +
                ", cityId=" + cityId +
                '}';
    }
}
