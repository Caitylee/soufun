package com.qf.house.service;

import com.qf.house.domain.House;

import java.util.List;

/**
 * @author yangbo
 *
 */
public interface HouseService {

    boolean addHouse();

    boolean deleteHouse();

    boolean updateHouse();

    House findHouse();

    List<House> findAllHouse();





}
