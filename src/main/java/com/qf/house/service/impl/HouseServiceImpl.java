package com.qf.house.service.impl;

import com.qf.house.domain.House;
import com.qf.house.domain.HouseType;
import com.qf.house.dto.SearchHouseParam;
import com.qf.house.persistence.HouseDao;
import com.qf.house.persistence.HouseTypeDao;
import com.qf.house.service.HouseService;
import com.qf.house.util.HqlQueryBean;
import com.qf.house.util.PageBean;
import com.qf.house.util.QueryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author yangbo
 */
@Service
public class HouseServiceImpl implements HouseService{
    @Autowired
    private HouseTypeDao houseTypeDao;

    @Autowired
    private HouseDao houseDao;

    @Transactional(readOnly = true,rollbackFor = Exception.class)
    @Override
    public List<HouseType> listAllHouseType() {
        return houseTypeDao.findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean publishNewHouse(House house) {
        return houseDao.save(house)!=null;
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteHouse() {
        return false;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateHouse() {
        return false;
    }

    @Transactional(readOnly = true,rollbackFor = Exception.class)
    @Override
    public House findHouse() {
        return null;
    }

    @Transactional(readOnly = true,rollbackFor = Exception.class)
    @Override
    public PageBean<House> listHouseByPage(int page, int size) {
        return houseDao.findByPage(page,size);
    }


    @Transactional(readOnly = true,rollbackFor = Exception.class)
    @Override
    public PageBean<House> searchHousesWithParamByPage(SearchHouseParam houseParam, int page, int size) {
        QueryBean queryBean=new HqlQueryBean(House.class)
                .addCondition("title like ?","%"+houseParam.getTitle()+"%")
                .addCondition("area>=?",houseParam.getMinArea())
                .addCondition("area<=?",houseParam.getMaxArea())
                .addCondition("price>=?",houseParam.getMinPrice())
                .addCondition("price<=?",houseParam.getMaxPrice())
                .addCondition(houseParam.getHouseType().getId()!=0,"houseType=?",houseParam.getHouseType())
                .addOrderBy("pubDate");
        return houseDao.findByQueryAndPage(queryBean,page,size);

    }

    @Transactional(readOnly = true,rollbackFor = Exception.class)
    @Override
    public List<House> findAllHouse() {
        return houseDao.findAll();
    }
}
