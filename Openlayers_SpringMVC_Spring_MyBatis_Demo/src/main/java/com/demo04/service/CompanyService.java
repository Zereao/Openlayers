package com.demo04.service;

import net.sf.json.JSONArray;

public interface CompanyService {
    JSONArray getCompanyByProvince(String province);
}
