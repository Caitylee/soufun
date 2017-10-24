package com.qf.house.persistence.impl;


import com.qf.house.domain.City;
import com.qf.house.domain.Province;
import com.qf.house.persistence.CityDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CityDaoImpl extends BaseDaoAdapter<City,Integer> implements CityDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<City> findAllByProvince(Province province) {
        return sessionFactory.getCurrentSession().createQuery("from City as c where c.province=:province",City.class)
                .setParameter("province", province)
                .getResultList();
    }
}
