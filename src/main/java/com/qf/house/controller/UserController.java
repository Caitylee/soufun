package com.qf.house.controller;

import com.qf.house.domain.House;
import com.qf.house.domain.User;
import com.qf.house.dto.CheckResult;
import com.qf.house.dto.UserLoginDto;
import com.qf.house.service.HouseService;
import com.qf.house.service.UserService;
import com.qf.house.util.CommonUtil;
import com.qf.house.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.awt.image.BufferedImage;
import java.util.List;

/**
 * @author yangbo
 */

@Controller
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping(value = "/doLogin")
    public String doLogin(@Valid UserLoginDto user,Errors error, HttpServletRequest request, Model model) {
        String url = "login";
        HttpSession session=request.getSession();
        if (user.getCode().equalsIgnoreCase(session.getAttribute("code").toString())) {
            if (!error.hasErrors()) {
                user.setIpAddress(request.getRemoteAddr());
                boolean flag = userService.login(user);
                if (flag) {
                    session.setAttribute("userId", user.getId());
                    session.setAttribute("userRealname", user.getRealname());
                    url = "redirect:home";
                } else {
                    model.addAttribute("hint", "用户名或密码错误");
                }
            } else {
                model.addAttribute("hint", "请输入有效的用户信息");
            }
        } else {
            model.addAttribute("hint", "验证码错误");
        }
        return url;
    }


    @PostMapping(value = "/doRegister")
    public String doRegister(@Valid User user, Errors errors, Model model, String code, HttpServletRequest request) {
        String url = "register";
        HttpSession session=request.getSession();
        if (!errors.hasErrors()) {
            if (code.equalsIgnoreCase(session.getAttribute("code").toString())) {
                boolean flag = userService.register(user);
                if (flag) {
                    url = "redirect:toLogin";
                } else {
                    model.addAttribute("hint", "用户名已存在");
                }
            } else {
                model.addAttribute("hint", "验证码错误");
            }
        } else {
            model.addAttribute("hint", "请输入有效的注册信息");
        }
        return url;
    }



    @GetMapping(value = "/Logout")
    public String toLogout(HttpSession httpSession) {
        httpSession.removeAttribute("userId");
        return "redirect:home";
    }

    @GetMapping(value = "/toUserInfo")
    public String toUserInfo() {
        return "userinfo";
    }


    /**
     * 验证码
     * @param response 响应
     * @param session 会话
     * @return 验证码图片
     */
    @GetMapping(value = "/code", produces = "image/png")
    @ResponseBody
    public BufferedImage codeCheck(HttpServletResponse response, HttpSession session) {
        final int len = 4;
        String code = CommonUtil.generateCode(len);
        session.setAttribute("code", code);
        return CommonUtil.generateCodeImage(code, 80, 30);
    }

    @GetMapping(value = "/check")
    @ResponseBody
    public CheckResult checkUsername(String username){
        boolean valid=userService.checkUnique(username);
        return new CheckResult(username,valid,valid?"用户名可用":"用户名不可用",valid?"ok.png":"no.png");
    }
}
