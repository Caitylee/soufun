package com.qf.house.controller;

import com.qf.house.domain.City;
import com.qf.house.domain.Distric;
import com.qf.house.domain.House;
import com.qf.house.domain.Province;
import com.qf.house.service.HouseService;
import com.qf.house.service.LocationService;
import com.qf.house.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private LocationService locationService;


    @Autowired
    private HouseService houseService;

    @GetMapping(value = "/home")
    public String toHome(Model model, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "6") int size) {
        PageBean<House> pageBean=houseService.listHouseByPage(page, size);
        model.addAttribute("houseList",pageBean.getHouseList());
        model.addAttribute("currentPage",pageBean.getCurrentPage());
        model.addAttribute("totalPage",pageBean.getTotalPage());
        model.addAttribute("pageBean",pageBean);
        return "index";
    }

    @GetMapping(value = "/toLogin")
    public String toLogin() {
        return "login";
    }


    @GetMapping(value = "/toPub")
    public String toPub(){
        return "pub";
    }


    @GetMapping(value = "/cities")
    @ResponseBody
    public List<City> getCities(Province province) {
        return locationService.listAllCitiesByProvince(province);
    }

    @GetMapping(value = "/districts")
    @ResponseBody
    public List<Distric> getDistricts(City city){
        return  locationService.listAllDistricsByCity(city);
    }

    @GetMapping(value = "/toRegister")
    public String toRegister() {
        return "register";
    }
}
