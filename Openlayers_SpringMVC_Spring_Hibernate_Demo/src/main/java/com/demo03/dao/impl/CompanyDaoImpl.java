package com.demo03.dao.impl;

import com.demo03.dao.CompanyDao;
import com.demo03.entity.CompanyEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CompanyDaoImpl implements CompanyDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public CompanyDaoImpl(SessionFactory sessionFactory) {
        System.out.println(sessionFactory);
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        System.out.println("++++++++++++++++++++++++++");
        System.out.println(sessionFactory == null);
        System.out.println("++++++++++++++++++++++++++");
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<CompanyEntity> getData(String province) {
        String HQL = "from CompanyEntity where province like '%" + province + "%'";
        System.out.println("#" + HQL + "#");
        System.out.println(getSession());
        Query query = getSession().createQuery(HQL);
        List list = query.list();
        System.out.println(list);
        //noinspection unchecked
        return query.getResultList();
    }
}
