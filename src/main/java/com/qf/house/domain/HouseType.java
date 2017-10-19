package com.qf.house.domain;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "tb_house_type")
@Component
public class HouseType {
    @Id
    @Column(name = "typeid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String typename;


    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }


}
