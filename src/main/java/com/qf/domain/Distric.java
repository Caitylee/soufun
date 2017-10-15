package com.qf.domain;

import javax.persistence.*;

@Entity
@Table(name = "tb_district")
public class Distric {
    @Id
    private Integer distid;
    private String distname;
    @ManyToOne
    private Integer cityId;

    
    public Integer getDistid() {
        return distid;
    }

    public void setDistid(Integer distid) {
        this.distid = distid;
    }

   
    public String getDistname() {
        return distname;
    }

    public void setDistname(String distname) {
        this.distname = distname;
    }

   
    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Distric that = (Distric) o;

        if (distid != that.distid) return false;
        if (cityId != that.cityId) return false;
        if (distname != null ? !distname.equals(that.distname) : that.distname != null) return false;

        return true;
    }

    @Override
    public int  hashCode() {
        int result = distid;
        result = 31 * result + (distname != null ? distname.hashCode() : 0);
        result = 31 * result + cityId;
        return result;
    }
}
