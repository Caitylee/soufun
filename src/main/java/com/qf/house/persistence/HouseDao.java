package com.qf.house.persistence;

import com.qf.house.domain.City;
import com.qf.house.domain.Distric;
import com.qf.house.domain.House;
import com.qf.house.domain.HouseType;
import com.qf.house.util.PageBean;
import com.qf.house.util.QueryBean;

import java.util.List;

/**
 * @author 羊波
 */
public interface HouseDao extends BaseDao<House,Integer>{


    /**
     * 查询该市所有房源
     * @param city 城市
     * @return 房屋列表
     */
    List<House> findByCity(City city);

    /**
     * 根据房源类型查询房源
     * @param houseType 房间类型
     * @return 房屋列表
     */
    List<House> findByHouseType(HouseType houseType);

    /**
     * 根据区域查询房源
     * @param distric 区域
     * @return 房屋列表
     */
    List<House> findByDistric(Distric distric);

    /**
     * 根据价格查询房源
     * @param price 房屋价格
     * @return 房屋列表
     */
    List<House> findByPrice(Double price);

    /**
     * 根据页码及页码大小返回房屋列表
     * @param page 当前页
     * @param size 当前页大小
     * @return 房屋列表
     */
    PageBean<House> findByPage(int page, int size);

    /**
     * 多条件查询
     * @param queryBean 查询语句
     * @param page 当前页
     * @param size 页面大小
     * @return 分页器对象
     */
    PageBean<House> findByQueryAndPage(QueryBean queryBean, int page, int size);

}
