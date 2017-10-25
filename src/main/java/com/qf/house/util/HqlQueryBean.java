package com.qf.house.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangbo
 */
public class HqlQueryBean implements QueryBean {
    private String fromClouse;
    private String whereClouse;
    private String orderByClouse;
    private List<Object> paramValues= new ArrayList<>();

    public HqlQueryBean(Class<?> entityType) {
        fromClouse="from "+entityType.getSimpleName()+" as o";
    }

    @Override
    public List<Object> getParameters() {
        return paramValues;
    }

    @Override
    public QueryBean addOrderBy(boolean flag, String keyWord, boolean asc) {
        if (flag){
            if (orderByClouse==null){
                orderByClouse=" order by o."+keyWord+(asc?" asc":" desc");
            }else {
                orderByClouse=",o."+keyWord+(asc?" asc":" desc");
            }
        }
        return this;
    }

    @Override
    public QueryBean addCondition(boolean flag, String condition, Object value) {
        if (flag){
            if (whereClouse==null){
                whereClouse=" where o."+condition;
            }else {
                whereClouse+=" and o."+condition;
            }
            paramValues.add(value);
        }

        return this;
    }

    @Override
    public QueryBean addCondition(String condition, Object value) {
        if (whereClouse==null){
            whereClouse=" where o."+condition;
        }else {
            whereClouse+=" and o."+condition;
        }
        paramValues.add(value);
        return this;
    }

    @Override
    public String getQueryString() {
        return fromClouse+" "+whereClouse+" "+orderByClouse;
    }

    @Override
    public String getCountString() {
        return "select count(o)"+fromClouse+" "+whereClouse;
    }

}
