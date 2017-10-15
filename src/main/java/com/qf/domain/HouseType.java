package com.qf.domain;

import javax.persistence.*;

@Entity
@Table(name = "tb_house_type", schema = "house", catalog = "")
public class HouseType {
    @Id
    @Column(name = "typeid")
    private int id;
    private String typename;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HouseType that = (HouseType) o;

        if (id != that.id) return false;
        if (typename != null ? !typename.equals(that.typename) : that.typename != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (typename != null ? typename.hashCode() : 0);
        return result;
    }
}
