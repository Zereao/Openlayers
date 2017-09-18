package dao;

import db.DBUtil;
import entity.Entity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class CompanyDao {

    public List<Entity> getData(String province){
        Session session = DBUtil.getSession();
        try {
            String HQL = "from Entity where province = '"+ province + "'";   //使用Hibernate的HQL语句查询
            Query query = session.createQuery(HQL);
            return query.getResultList();
        }finally {
//            if (session != null)
//                session.close();
        }
    }
}
