package com.qf.house.persistence.impl;



import com.qf.house.domain.City;
import com.qf.house.domain.Distric;
import com.qf.house.persistence.DistricDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 羊波
 */
@Repository
public class DistricDaoImpl extends BaseDaoAdapter<Distric,Integer> implements DistricDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Distric> findAllByCity(City city) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Distric as d where d.city=:city",Distric.class)
                .setParameter("city",city)
                .getResultList();
    }
}
