package com.hyl.dao;


import com.hyl.model.CompanyBean;

import java.util.List;

public interface CompanyMapper {
    List<CompanyBean> selectByProvince(String province);
}