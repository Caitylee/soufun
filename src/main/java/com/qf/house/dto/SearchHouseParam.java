package com.qf.house.dto;

import com.qf.house.domain.HouseType;

/**
 * 房屋查询DTO
 *
 * @author 羊波
 */
public class SearchHouseParam {
    private String title;
    private String price;
    private HouseType houseType;
    private String area;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getMinPrice() {
        if (price.equals("不限")) {
            return 0.0;
        } else {
            return Double.parseDouble(price.split("-")[0]);
        }
    }


    public Double getMaxPrice() {
        if (price.equals("不限")) {
            return Double.MAX_VALUE;
        } else {
            return Double.parseDouble(price.split("-")[1]);
        }
    }


    public void setPrice(String price) {
        this.price = price;
    }

    public HouseType getHouseType() {
        return houseType;
    }

    public void setHouseType(HouseType houseType) {
        this.houseType = houseType;
    }

    public Integer getMinArea() {
        return area.equals("不限") ? 0 : Integer.parseInt(area.split("-")[0]);
    }

    public Integer getMaxArea() {
        return area.equals("不限") ? Integer.MAX_VALUE : Integer.parseInt(area.split("-")[1]);
    }


    public void setArea(String area) {
        this.area = area;
    }
}
