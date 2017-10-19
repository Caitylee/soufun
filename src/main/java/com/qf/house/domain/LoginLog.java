package com.qf.house.domain;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * @author 羊波
 */
@Entity
@Table(name = "tb_login_log")
@Component
public class LoginLog implements Serializable{
    @Id
    @Column(name = "loginid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String ipaddr;
    private Date logdate;

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public String getIpaddr() {
        return ipaddr;
    }

    public void setIpaddr(String ipaddr) {
        this.ipaddr = ipaddr;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getLogdate() {
        return logdate;
    }

    public void setLogdate(Date logdate) {
        this.logdate = logdate;
    }


}
