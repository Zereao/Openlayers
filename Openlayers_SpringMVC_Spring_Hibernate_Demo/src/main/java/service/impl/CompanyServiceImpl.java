package service.impl;

import dao.CompanyDao;
import entity.CompanyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.CompanyService;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyDao companyDao;

    @Override
    public List<CompanyEntity> getData(String province) {
        return companyDao.getData(province);
    }
}
