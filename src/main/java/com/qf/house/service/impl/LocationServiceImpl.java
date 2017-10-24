package com.qf.house.service.impl;

import com.qf.house.domain.City;
import com.qf.house.domain.Distric;
import com.qf.house.domain.Province;
import com.qf.house.persistence.CityDao;
import com.qf.house.persistence.DistricDao;
import com.qf.house.persistence.ProvinceDao;
import com.qf.house.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *@author yangbo
 */
@Service
@Transactional
public class LocationServiceImpl implements LocationService {
    @Autowired
    private ProvinceDao provinceDao;
    @Autowired
    private CityDao cityDao;
    @Autowired
    private DistricDao districDao;
    @Override
    public List<Province> listAllProvinces() {
        return provinceDao.findAll();
    }

    @Override
    public List<City> listAllCitiesByProvince(Province province) {
        return cityDao.findAllByProvince(province);
    }

    @Override
    public List<Distric> listAllDistricsByCity(City city) {
        return districDao.findAllByCity(city);
    }
}
