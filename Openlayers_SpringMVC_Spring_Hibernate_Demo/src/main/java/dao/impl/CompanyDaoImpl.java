package dao.impl;

import dao.CompanyDao;
import entity.CompanyEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CompanyDaoImpl implements CompanyDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<CompanyEntity> getData(String province) {
        String HQL = "from CompanyEntity where province = '" + province + "'";
        Query query = getSession().createQuery(HQL);
        return query.getResultList();
    }
}
