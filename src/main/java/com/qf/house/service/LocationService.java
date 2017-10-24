package com.qf.house.service;

import com.qf.house.domain.City;
import com.qf.house.domain.Distric;
import com.qf.house.domain.Province;

import java.util.List;

/**
 * 发布房屋业务接口
 * @author yangbo
 */
public interface LocationService {

    /**
     * 列出省份
     * @return 所有省份
     */
    List<Province> listAllProvinces();

    /**
     * 列出城市
     * @return 该省份下所有的城市
     */
    List<City> listAllCitiesByProvince(Province province);

    /**
     * 列出区域
     * @return 该城市下所有的区域
     */
    List<Distric> listAllDistricsByCity(City city);
}
