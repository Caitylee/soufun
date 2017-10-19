package com.qf.house.domain;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_user")
@Component
public class User {
    @Id
    @Column(name = "userid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Pattern(regexp = "\\w{5,20}")
    private String username;
    @Size(min = 6)
    private String password;
    private String realname;
    private String tel;
    @Column(name = "isadmin")
    private Boolean admin;

   
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

   
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

   
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }


    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

}
