package com.qf.persistence;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<E,K extends Serializable> {
    /**
     * 添加实体
     * @param e 实体对象
     * @return 实体主键
     */
    K save(E e);


    /**
     * 删除实体
     * @param k 实体主键
     * @return 删除成功返回true
     */
    boolean delete(K k);

    /**
     * 更新实体对象
     * @param e 实体对象
     * @return 实体对象
     */
    E update(E e);


    /**
     * 根据主键查询实体
     * @param k 实体主键
     * @return 实体对象
     */
    E find(K k);

    /**
     * 查询所有实体
     * @return 实体集合
     */
    List<E> findAll();

}
