package com.qf.domain;

import javax.persistence.*;

@Entity
@Table(name = "tb_user")
public class User {
    @Id
    @Column(name = "userid")
    private Integer id;
    private String username;
    private String password;
    private String realname;
    private String tel;
    private Boolean isadmin;

   
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


    public Boolean getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(Boolean isadmin) {
        this.isadmin = isadmin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User that = (User) o;

        if (id != that.id) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (realname != null ? !realname.equals(that.realname) : that.realname != null) return false;
        if (tel != null ? !tel.equals(that.tel) : that.tel != null) return false;
        if (isadmin != null ? !isadmin.equals(that.isadmin) : that.isadmin != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int  result = id;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (realname != null ? realname.hashCode() : 0);
        result = 31 * result + (tel != null ? tel.hashCode() : 0);
        result = 31 * result + (isadmin != null ? isadmin.hashCode() : 0);
        return result;
    }
}
