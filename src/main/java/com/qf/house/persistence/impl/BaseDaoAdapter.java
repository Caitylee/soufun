package com.qf.house.persistence.impl;


import com.qf.house.persistence.BaseDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
/**
 * @author 羊波
 * basedao适配器
 */
@Repository
public abstract class BaseDaoAdapter<E, K extends Serializable> implements BaseDao<E, K> {
    private Class<E> entityType; //通过反射可得到类的类型及名字
    private String entityName;

    @Autowired
    protected SessionFactory sessionFactory;

    protected BaseDaoAdapter() {
        //获取带泛型的父类
        ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
        //通过但泛型的父类获取真实的参数类型
        entityType = (Class<E>) parameterizedType.getActualTypeArguments()[0];
        entityName = entityType.getSimpleName();
    }


    @Override
    public K save(E e) {
        return (K) sessionFactory.getCurrentSession().save(e);
    }

    @Override
    public boolean delete(K k) {
        return sessionFactory.getCurrentSession().createQuery(" delete from "+entityName+" as o where o.id=:id ",entityType)
                .setParameter("id",k)
                .executeUpdate()==1;
    }

    @Override
    public void delete(E e) {
        sessionFactory.getCurrentSession().delete(e);
    }

    @Override
    public E update(E e) {
        return (E) sessionFactory.getCurrentSession().merge(e);
    }

    @Override
    public E find(K k) {
        return sessionFactory.getCurrentSession().get(entityType,k);
    }

    @Override
    public List<E> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from "+entityName,entityType).getResultList();
    }
}
