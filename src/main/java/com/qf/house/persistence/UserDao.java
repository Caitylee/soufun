package com.qf.house.persistence;

import com.qf.house.domain.User;

/**
 * @author 羊波
 */
public interface UserDao extends BaseDao<User,Integer>{
    User findByUserName(String username);
}
