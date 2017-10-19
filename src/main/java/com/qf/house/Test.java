package com.qf.house;

import com.qf.house.domain.User;

public class Test {

    public static User change(User user){
        User temp=new User();
        temp.setRealname("aaa");
        user=temp;
        return user;
    }

    public static void main(String[] args) {
        User user=new User();
        user.setRealname("ccc");
        user=change(user);
        System.out.println(user.getRealname());
    }
}
