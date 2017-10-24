package com.qf.house.domain;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "tb_district")
@Component
public class Distric {
    @Id
    @Column(name = "distid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "distname")
    private String name;
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    
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

   
    public City getCity(){
        return city;
    }

    public void setCityId(City city) {
        this.city = city;
    }


}
