package com.qf.domain;

import javax.persistence.*;

@Entity
@Table(name = "tb_city")
public class City {
    @Id
    @Column(name="cityid")
    private Integer id;
    private String name;
    @ManyToOne
    private Integer provId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Integer getProvId() {
        return provId;
    }

    public void setProvId(Integer provId) {
        this.provId = provId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City that = (City) o;

        if (id != that.id) return false;
        if (provId != that.provId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + provId;
        return result;
    }
}
