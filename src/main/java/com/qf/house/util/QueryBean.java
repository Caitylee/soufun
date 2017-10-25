package com.qf.house.util;


import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 查询对象接口
 * 把查询条件，排序条件 封装到一个对象中去，直接生成查询语句
 * @author yangbo
 */
public interface QueryBean {

    /**
     * 获取参数
     * @return 参数列表
     */
    List<Object> getParameters();

    /**
     * 添加排序关键字
     * @param flag 是否添加
     * @param keyWord 关键字
     * @param asc 降序或者升序
     * @return QueryBean 对象
     */
    QueryBean addOrderBy(boolean flag, String keyWord, boolean asc);

    /**
     *
     * @param keyWord 关键字
     * @param asc 升序
     * @return QueryBean 对象
     */
    default QueryBean addOrderBy(String keyWord, boolean asc){
        return addOrderBy(true,keyWord,true);
    };

    default QueryBean addOrderBy(String keyWord){
        return addOrderBy(true,keyWord,true);
    };

    /**
     * 添加条件的方法
     * @param flag 是否添加
     * @param condition 条件
     * @param value 值
     * @return queryBean
     */
    QueryBean addCondition(boolean flag, String condition, Object value);


    /**
     *
     * @param condition 条件
     * @param value 值
     * @return queryBean对象
     */
    QueryBean addCondition(String condition, Object value);

    /**
     * 获得查询语句
     * @return 查询语句
     */
    String getQueryString();

    /**
     * 获得查询记录数
     * @return 查询记录数
     */
    String getCountString();
}
