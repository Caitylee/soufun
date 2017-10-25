package com.qf.house.persistence.impl;


import com.qf.house.domain.City;
import com.qf.house.domain.Distric;
import com.qf.house.domain.House;
import com.qf.house.domain.HouseType;
import com.qf.house.persistence.HouseDao;
import com.qf.house.util.PageBean;
import com.qf.house.util.QueryBean;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * @author yangbo
 */
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
    public PageBean<House> findByQueryAndPage(QueryBean queryBean, int page, int size) {
        Query query=sessionFactory.getCurrentSession()
                .createQuery(queryBean.getQueryString(),House.class);
        List<Object> parameValues=queryBean.getParameters();
        for (int i=0;i<parameValues.size();i++){
            query.setParameter(i,queryBean.getParameters().get(i));
        }
        List<House> houseList=query.setFirstResult((page-1)*size).setMaxResults(size).getResultList();
        query=sessionFactory.getCurrentSession().createQuery(queryBean.getCountString());
        for (int i = 0; i < parameValues.size(); i++) {
            query.setParameter(i,queryBean.getParameters().get(i));
        }
        int count= ((Long)query.getSingleResult()).intValue();
        int totalPage=(count-1)/size+1;
        return new PageBean<>(houseList,page,size,totalPage);
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
