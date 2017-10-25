package com.qf.house.service;

import com.qf.house.domain.House;
import com.qf.house.domain.HouseType;
import com.qf.house.dto.SearchHouseParam;
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

    /**
     * 房屋分页
     * @param page 当前页
     * @param size 页面大小
     * @return 分页器对象
     */
    PageBean<House> listHouseByPage(int page,int size);

    /**
     * 根据房屋参数进行条件查询
     * @param houseParam 房屋参数
     * @param page 当前页
     * @param size 页面大小
     * @return 当前页所有房屋的集合
     */
    PageBean<House> searchHousesWithParamByPage(SearchHouseParam houseParam,int page,int size);








}
