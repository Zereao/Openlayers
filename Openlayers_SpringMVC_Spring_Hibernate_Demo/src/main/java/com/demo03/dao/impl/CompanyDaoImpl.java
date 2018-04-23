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
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<CompanyEntity> getData(String province) {
        province = "上海";
        String HQL = "from CompanyEntity where province LIKE '%" + province + "%'";
        System.out.println("#" + HQL + "#");
        Query query = getSession().createQuery(HQL);
        List list = query.list();
        System.out.println(list);
        //noinspection unchecked
        return query.getResultList();
    }
}
