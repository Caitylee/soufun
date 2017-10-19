package com.qf.house.persistence;

import com.qf.house.domain.City;
import com.qf.house.domain.Distric;
import com.qf.house.domain.House;
import com.qf.house.domain.HouseType;

import java.util.List;

/**
 * @author 羊波
 */
public interface HouseDao extends BaseDao<House,Integer>{


    /**
     * 查询该市所有房源
     * @param city
     * @return
     */
    List<House> findByCity(City city);

    /**
     * 根据房源类型查询房源
     * @param houseType 房间类型
     * @return
     */
    List<House> findByHouseType(HouseType houseType);

    /**
     * 根据区域查询房源
     * @param distric 区域
     * @return
     */
    List<House> findByDistric(Distric distric);

    /**
     * 根据价格查询房源
     * @param price
     * @return
     */
    List<House> findByPrice(Double price);

}
