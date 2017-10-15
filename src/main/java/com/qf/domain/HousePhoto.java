package com.qf.domain;

import javax.persistence.*;

@Entity
@Table(name = "tb_house_photo")
public class HousePhoto {
    @Id
    @Column(name = "photoid")
    private Integer id;
    private String photoname;
    private Integer houseId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getPhotoname() {
        return photoname;
    }

    public void setPhotoname(String photoname) {
        this.photoname = photoname;
    }


    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HousePhoto that = (HousePhoto) o;

        if (id != that.id) return false;
        if (houseId != that.houseId) return false;
        if (photoname != null ? !photoname.equals(that.photoname) : that.photoname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (photoname != null ? photoname.hashCode() : 0);
        result = 31 * result + houseId;
        return result;
    }
}
