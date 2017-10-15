package com.qf.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "tb_login_log")
public class LoginLog implements Serializable{
    @Id
    @Column(name = "loginid")
    private Integer id;
    private Integer userId;
    private String ipaddr;
    private Timestamp logdate;

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


    public String getIpaddr() {
        return ipaddr;
    }

    public void setIpaddr(String ipaddr) {
        this.ipaddr = ipaddr;
    }


    public Timestamp getLogdate() {
        return logdate;
    }

    public void setLogdate(Timestamp logdate) {
        this.logdate = logdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoginLog that = (LoginLog) o;

        if (id != that.id) return false;
        if (userId != that.userId) return false;
        if (ipaddr != null ? !ipaddr.equals(that.ipaddr) : that.ipaddr != null) return false;
        if (logdate != null ? !logdate.equals(that.logdate) : that.logdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int  result = id;
        result = 31 * result + userId;
        result = 31 * result + (ipaddr != null ? ipaddr.hashCode() : 0);
        result = 31 * result + (logdate != null ? logdate.hashCode() : 0);
        return result;
    }
}
