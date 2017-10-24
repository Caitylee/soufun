package com.qf.house.service;

import com.qf.house.domain.User;
import com.qf.house.dto.UserLoginDto;

/**
 * 用户业务接口
 * @author yangbo
 */
public interface UserService {

    /**
     * 登录
     * @param user 用户对象
     * @return 成功True 失败False
     */
    boolean login(UserLoginDto user);

    /**
     * 注册
     * @param user 用户对象
     * @return 成功True 失败False
     */
    boolean register(User user);

    boolean checkUnique(String username);
}
