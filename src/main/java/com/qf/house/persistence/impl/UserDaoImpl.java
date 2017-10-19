package com.qf.house.persistence.impl;

import com.qf.house.domain.User;
import com.qf.house.persistence.UserDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 羊波
 */
@Repository
public class UserDaoImpl extends BaseDaoAdapter<User,Integer> implements UserDao {


    @Override
    public User findByUserName(String username) {
        List<User> userList=sessionFactory.getCurrentSession()
                .createQuery("from User as u where u.username=:username",User.class)
                .setParameter("username",username)
                .getResultList();
        return userList.size()==1?userList.get(0):null;
    }
}
