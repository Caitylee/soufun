package com.qf.house.service.impl;

import com.qf.house.domain.LoginLog;
import com.qf.house.domain.User;
import com.qf.house.dto.UserLoginDto;
import com.qf.house.persistence.LoginLogDao;
import com.qf.house.persistence.UserDao;
import com.qf.house.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author yangbo
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private LoginLogDao loginLogDao;

    @Override
    public boolean login(UserLoginDto user) {
        boolean flag = false;
        String username = user.getUsername();
        User temp = userDao.findByUserName(username);
        if (temp != null) {
            String md5 = DigestUtils.md5Hex(user.getPassword());
            flag = temp.getPassword().equals(md5);
            if (flag) {
                user.setId(temp.getId());
                user.setRealname(temp.getRealname());
                LoginLog loginLog = new LoginLog();
                loginLog.setUser(temp);
                loginLog.setIpaddr(user.getIpAddress());
                loginLog.setLogdate(new Date());
                loginLogDao.save(loginLog);
            }
        }
        return flag;
    }

    @Override
    public boolean register(User user) {
        String username = user.getUsername();
        User temp = userDao.findByUserName(username);
        if (temp != null) {
            return false;
        } else {
            user.setPassword(DigestUtils.md5Hex(user.getPassword()));
            user.setAdmin(false);
            return userDao.save(user) != null;
        }
    }

    @Override
    public boolean checkUnique(String username) {
        return  userDao.findByUserName(username)==null;
    }
}
