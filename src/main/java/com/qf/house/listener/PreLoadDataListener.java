package com.qf.house.listener;

import com.qf.house.service.HouseService;
import com.qf.house.service.LocationService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class PreLoadDataListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext=sce.getServletContext();
       WebApplicationContext context= WebApplicationContextUtils.getWebApplicationContext(servletContext);
        HouseService houseService=context.getBean(HouseService.class);
        LocationService locationService=context.getBean(LocationService.class);
        servletContext.setAttribute("houseTypeList",houseService.listAllHouseType());
        servletContext.setAttribute("provinceList",locationService.listAllProvinces());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        sce.getServletContext().removeAttribute("houseTypeList");
        sce.getServletContext().removeAttribute("provinceList");

    }
}
