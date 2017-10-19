package com.qf.house.controller;

import com.qf.house.domain.User;
import com.qf.house.service.UserService;
import com.qf.house.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @author  yangbo
 */

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/home")
    public String toHome(){
        return "index";
    }

    @GetMapping(value = "/toLogin")
    public String toLogin(){
        return "login";
    }

    @PostMapping(value = "/doLogin")
    public String doLogin(@Valid User user, Errors error, HttpSession httpSession, Model model){
        String url="login";
        if (!error.hasErrors()){
            boolean flag=userService.login(user);
            if (flag){
                httpSession.setAttribute("user",user);
                url= "redirect:home";
            }else {
                model.addAttribute("hint","用户名或密码错误");
            }
        }else {
            model.addAttribute("hint","请输入有效的用户信息");
        }
        return url;

    }



    @PostMapping(value = "/doRegister")
    public String doRegister(@Valid User user,Errors errors,Model model,String code,HttpSession session){
        String url="register";
        if (!errors.hasErrors()){
            if (code.equalsIgnoreCase(session.getAttribute("code").toString())){
                boolean flag=userService.register(user);
                if(flag){
                    url= "redirect:toLogin";
                }else {
                    model.addAttribute("hint","用户名已存在");
                }
            }else {
                model.addAttribute("hint","验证码错误");
            }
        }else{
            model.addAttribute("hint","请输入有效的注册信息");
        }
        return url;
    }

    @GetMapping(value = "/toRegister")
    public String toRegister(){
        return "register";
    }

    @GetMapping(value = "/Logout")
    public String toLogout(HttpSession httpSession){
        httpSession.removeAttribute("user");
        return "redirect:home";
    }

    @GetMapping(value = "/toUserInfo")
    public String toUserInfo(){
        return "userinfo";
    }

    @GetMapping(value = "/code")
    public void codeCheck(HttpServletResponse response, HttpSession session)
    throws IOException{
        final int len = 4;
        String code=CommonUtil.generateCode(len);
        session.setAttribute("code",code);
        BufferedImage bufferedImage= CommonUtil.generateCodeImage(code,80,30);
        response.setContentType("image/png");
        ImageIO.write(bufferedImage, "PNG", response.getOutputStream());

    }
}
