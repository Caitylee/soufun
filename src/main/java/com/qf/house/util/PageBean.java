package com.qf.house.util;

import java.util.List;

/**
 * 分页器
 * @param <House> 房屋列表
 * @author YANGBO
 */
public class PageBean<House> {
    private List<House> houseList;
    private int currentPage;
    private int size;
    private int totalPage;

    public PageBean() {
    }

    public PageBean(List<House> houseList, int currentPage, int size, int totalPage) {
        this.houseList = houseList;
        this.currentPage = currentPage;
        this.size = size;
        this.totalPage = totalPage;
    }

    public List<House> getHouseList() {
        return houseList;
    }

    public void setHouseList(List<House> houseList) {
        this.houseList = houseList;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
}
