package com.qf.house.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//@Controller
public class Home {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String foo(Model model){
        model.addAttribute("name","luohao");
        return "home";
    }


    /*@GetMapping(value = "/toReg")
    public ModelAndView toReg(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("register");
        modelAndView.addObject("hint","欢迎来登录");
        return modelAndView;
    }*/

}
