package com.qf.house.persistence;

import com.qf.house.domain.City;
import com.qf.house.domain.Province;

import java.util.List;

/**
 * @author 羊波
 */
public interface CityDao extends BaseDao<City,Integer>{

    /**
     * 根据省来查询所有的城市
     * @return 城市
     */
    List<City> findAllByProvince(Province province);
}
