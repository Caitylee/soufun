package com.qf.house.domain;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "tb_city")
@Component
public class City {
    @Id
    @Column(name="cityid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "cityname")
    private String name;
    @ManyToOne
    @JoinColumn(name = "prov_id")
    private Province province;


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


    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }


}
