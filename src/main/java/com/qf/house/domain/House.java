package com.qf.house.domain;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "tb_house")
@Component
public class House {
    @Id
    @Column(name="houseid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer area;
    private String contacterEmail;
    private String contacterName;
    private String contacterQq;
    private String contacterTel;
    private String detail;
    private Integer floor;
    private String mainPhoto;
    private double price;
    private Timestamp pubDate;
    private String street;
    private String title;
    private Integer totalFloor;
    private Integer districtId;
    @ManyToOne
    @JoinColumn(name = "houseTypeId")
    private HouseType houseType;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }


    public String getContacterEmail() {
        return contacterEmail;
    }

    public void setContacterEmail(String contacterEmail) {
        this.contacterEmail = contacterEmail;
    }

    public String getContacterName() {
        return contacterName;
    }

    public void setContacterName(String contacterName) {
        this.contacterName = contacterName;
    }


    public String getContacterQq() {
        return contacterQq;
    }

    public void setContacterQq(String contacterQq) {
        this.contacterQq = contacterQq;
    }


    public String getContacterTel() {
        return contacterTel;
    }

    public void setContacterTel(String contacterTel) {
        this.contacterTel = contacterTel;
    }


    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }


    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }


    public String getMainPhoto() {
        return mainPhoto;
    }

    public void setMainPhoto(String mainPhoto) {
        this.mainPhoto = mainPhoto;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Timestamp getPubDate() {
        return pubDate;
    }

    public void setPubDate(Timestamp pubDate) {
        this.pubDate = pubDate;
    }


    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public Integer getTotalFloor() {
        return totalFloor;
    }

    public void setTotalFloor(Integer totalFloor) {
        this.totalFloor = totalFloor;
    }


    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }


    public HouseType getHouseType() {
        return houseType;
    }

    public void setHouseTypeId(HouseType houseType) {
        this.houseType = houseType;
    }


    public User getUser() {
        return user;
    }

    public void setUserId(User user) {
        this.user=user;
    }


}
