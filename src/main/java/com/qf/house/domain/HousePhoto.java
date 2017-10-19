package com.qf.house.domain;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "tb_house_photo")
@Component
public class HousePhoto {
    @Id
    @Column(name = "photoid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "photoname")
    private String name;
    @ManyToOne
    @JoinColumn(name = "house_id")
    private House house;


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


    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }
}
