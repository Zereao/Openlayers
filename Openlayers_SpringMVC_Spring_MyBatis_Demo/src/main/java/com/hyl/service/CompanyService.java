package com.hyl.service;

import com.hyl.model.CompanyBean;

import java.util.List;

public interface CompanyService {
    List<CompanyBean> getCompanyByProvince(String province);
}
