package com.qf.domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "tb_house")
public class House {
    @Id
    @Column(name="houseid")
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
    private Integer houseTypeId;
    @ManyToOne
    private Integer userId;


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


    public Integer getHouseTypeId() {
        return houseTypeId;
    }

    public void setHouseTypeId(Integer houseTypeId) {
        this.houseTypeId = houseTypeId;
    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        House that = (House) o;

        if (id != that.id) return false;
        if (area != that.area) return false;
        if (floor != that.floor) return false;
        if (Double.compare(that.price, price) != 0) return false;
        if (userId != that.userId) return false;
        if (contacterEmail != null ? !contacterEmail.equals(that.contacterEmail) : that.contacterEmail != null)
            return false;
        if (contacterName != null ? !contacterName.equals(that.contacterName) : that.contacterName != null)
            return false;
        if (contacterQq != null ? !contacterQq.equals(that.contacterQq) : that.contacterQq != null) return false;
        if (contacterTel != null ? !contacterTel.equals(that.contacterTel) : that.contacterTel != null) return false;
        if (detail != null ? !detail.equals(that.detail) : that.detail != null) return false;
        if (mainPhoto != null ? !mainPhoto.equals(that.mainPhoto) : that.mainPhoto != null) return false;
        if (pubDate != null ? !pubDate.equals(that.pubDate) : that.pubDate != null) return false;
        if (street != null ? !street.equals(that.street) : that.street != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (totalFloor != null ? !totalFloor.equals(that.totalFloor) : that.totalFloor != null) return false;
        if (districtId != null ? !districtId.equals(that.districtId) : that.districtId != null) return false;
        if (houseTypeId != null ? !houseTypeId.equals(that.houseTypeId) : that.houseTypeId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + area;
        result = 31 * result + (contacterEmail != null ? contacterEmail.hashCode() : 0);
        result = 31 * result + (contacterName != null ? contacterName.hashCode() : 0);
        result = 31 * result + (contacterQq != null ? contacterQq.hashCode() : 0);
        result = 31 * result + (contacterTel != null ? contacterTel.hashCode() : 0);
        result = 31 * result + (detail != null ? detail.hashCode() : 0);
        result = 31 * result + floor;
        result = 31 * result + (mainPhoto != null ? mainPhoto.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (pubDate != null ? pubDate.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (totalFloor != null ? totalFloor.hashCode() : 0);
        result = 31 * result + (districtId != null ? districtId.hashCode() : 0);
        result = 31 * result + (houseTypeId != null ? houseTypeId.hashCode() : 0);
        result = 31 * result + userId;
        return result;
    }
}
