package com.qf.house.persistence;

import com.qf.house.domain.City;
import com.qf.house.domain.Distric;

import java.util.List;

/**
 * @author 羊波
 */
public interface DistricDao extends BaseDao<Distric,Integer>{
    /**
     * 查询该市所有区域
     * @return 区域
     */
    List<Distric> findAllByCity(City city);
}
