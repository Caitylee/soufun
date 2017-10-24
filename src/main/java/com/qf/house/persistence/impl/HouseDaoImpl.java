package com.qf.house.persistence.impl;


import com.qf.house.domain.City;
import com.qf.house.domain.Distric;
import com.qf.house.domain.House;
import com.qf.house.domain.HouseType;
import com.qf.house.persistence.HouseDao;
import com.qf.house.util.PageBean;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HouseDaoImpl extends BaseDaoAdapter<House,Integer> implements HouseDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<House> findByCity(City city) {
        return null;
    }

    @Override
    public PageBean<House> findByPage(int page, int size) {
        List<House> houseList=sessionFactory.getCurrentSession()
                .createQuery(" from House as h " +
                        "left join fetch h.houseType" +
                        " left join fetch h.district as d" +
                        " left join fetch d.city  as c" +
                        " left join  fetch c.province " +
                        "order by h.pubDate desc",House.class)
                .setFirstResult((page-1)*size)
                .setMaxResults(size)
                .getResultList();
        int count=sessionFactory.getCurrentSession()
                .createQuery("select count(h) from House as h",Long.class)
                .getSingleResult()
                .intValue();
        int totalPage=(count-1)/size+1;
        return new PageBean<House>(houseList,page,size,totalPage);
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
