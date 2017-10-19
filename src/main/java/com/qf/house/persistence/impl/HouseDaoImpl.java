package com.qf.house.persistence.impl;


import com.qf.house.domain.City;
import com.qf.house.domain.Distric;
import com.qf.house.domain.House;
import com.qf.house.domain.HouseType;
import com.qf.house.persistence.HouseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HouseDaoImpl extends BaseDaoAdapter<House,Integer> implements HouseDao {


    @Override
    public List<House> findByCity(City city) {
        return null;
    }

    @Override
    public List<House> findByHouseType(HouseType houseType) {
        return null;
    }

    @Override
    public List<House> findByDistric(Distric distric) {
        return null;
    }

    @Override
    public List<House> findByPrice(Double price) {
        return null;
    }
}
