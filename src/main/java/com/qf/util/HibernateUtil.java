package com.qf.util;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public final class HibernateUtil {

    public HibernateUtil() {
        throw  new AssertionError();
    }

    public static Session getSession(){
        return new Configuration().configure().buildSessionFactory().getCurrentSession();
    }
}
