package com.qf.house.service;

import com.qf.house.domain.House;
import com.qf.house.domain.HouseType;
import com.qf.house.util.PageBean;

import java.util.List;

/**
 * @author yangbo
 *
 */
public interface HouseService {

    /**
     * 根据房屋类型列出房屋
     * @return 房屋
     */
    List<HouseType> listAllHouseType();

    boolean deleteHouse();

    boolean updateHouse();

    House findHouse();

    List<House> findAllHouse();

    /**
     * 发布新房源
     * @param house 房源信息
     * @return 发布成功返回True否则返回false
     */
    boolean publishNewHouse(House house);

    PageBean<House> listHouseByPage(int page,int size);








}
