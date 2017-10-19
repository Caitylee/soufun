package com.qf.house.domain;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "tb_province")
@Component
public class Province {
    @Id
    @Column(name = "provid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "provname")
    private String name;

    
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

}
