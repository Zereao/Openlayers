package com.hyl.service.impl;

import com.hyl.dao.CompanyMapper;
import com.hyl.model.CompanyBean;
import com.hyl.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service()
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public List<CompanyBean> getCompanyByProvince(String province) {
        return companyMapper.selectByProvince(province);
    }
}
