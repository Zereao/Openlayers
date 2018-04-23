package com.demo02.dao;

import com.demo02.db.DBUtil;
import com.demo02.entity.CompanyEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class CompanyDao {

    public List<CompanyEntity> getData(String province) {
        Session session = DBUtil.getSession();
        String HQL = "from CompanyEntity where province LIKE '%" + province + "%'";   //使用Hibernate的HQL语句查询
        Query query = session.createQuery(HQL);
        //noinspection unchecked
        return query.getResultList();
    }
}
