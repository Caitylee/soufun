package com.qf.house.service;

import com.qf.house.domain.User;

/**
 * @author yangbo
 */
public interface UserService {

    /**
     * 登录
     * @param user 用户对象
     * @return 成功True 失败False
     */
    boolean login(User user);

    /**
     * 注册
     * @param user 用户对象
     * @return 成功True 失败False
     */
    boolean register(User user);
}
