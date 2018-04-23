package com.demo03.service;

import net.sf.json.JSONArray;

public interface CompanyService {
    JSONArray getCompanyByProvince(String province);
}
