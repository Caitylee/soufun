package com.qf.persistence.impl;


import com.qf.domain.City;
import com.qf.persistence.CityDao;
import com.qf.util.HibernateUtil;

import java.util.List;

public class CityDaoImpl extends BaseDaoAdapter implements CityDao {
    @Override
    public Integer save(City city) {
        return (Integer) HibernateUtil.getSession().save(city);
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }

    @Override
    public City update(City city) {
        return (City) HibernateUtil.getSession().merge(city);
    }

    @Override
    public City find(Integer integer) {
        return HibernateUtil.getSession().get(City.class,integer);
    }

    @Override
    public List<City> findAll() {
        return null;
    }
}
