package service;

import dao.CompanyDao;
import entity.CompanyEntity;

import java.util.List;

public class CompanyService {
    public List<CompanyEntity> query(String Province){
        try {
            CompanyDao dao = new CompanyDao();
            return dao.getData(Province);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
