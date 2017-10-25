package com.qf.house.controller;

import com.qf.house.domain.House;
import com.qf.house.domain.User;
import com.qf.house.dto.SearchHouseParam;
import com.qf.house.service.HouseService;
import com.qf.house.util.CommonUtil;
import com.qf.house.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @author yangbo
 */
@Controller
public class HouseController {
    @Autowired
    private HouseService houseService;

    @PostMapping(value = "/addHouse")
    public String addHouse(House house, MultipartFile primaryPhoto, MultipartFile[] photo, HttpServletRequest request) throws IOException {
        String originalFilename = primaryPhoto.getOriginalFilename();
        if (!primaryPhoto.isEmpty()) {
            String newFilename = CommonUtil.getUniqueFilename() + CommonUtil.getFilenameSuffix(originalFilename);
            String path = request.getServletContext().getRealPath("/images");
            primaryPhoto.transferTo(new File(path + "/" + newFilename));
            house.setMainPhoto(newFilename);
            house.setPubDate(new Date());
            User user = new User();
            user.setId((Integer) request.getSession().getAttribute("userId"));
            house.setUser(user);
        }
        if (houseService.publishNewHouse(house)) {
            return "redirect:home";
        } else {
            return "pub";
        }

    }

    @GetMapping(value = "/listHouse")
    @ResponseBody
    public PageBean<House> showHouse(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        return houseService.listHouseByPage(page, size);
    }

    @PostMapping(value = "/searchHouse")
    public String search(SearchHouseParam param,
                         @RequestParam(defaultValue = "1") int page,
                         @RequestParam(defaultValue = "10") int size,
                         Model model) {
        System.out.println(param.getMinArea());
        PageBean<House> pageBean= houseService.searchHousesWithParamByPage(param,page,size);
        model.addAttribute("houseList",pageBean.getHouseList());
        model.addAttribute("currentPage",pageBean.getCurrentPage());
        model.addAttribute("totalPage",pageBean.getTotalPage());
        return "index";
    }
}
