package com.demo03.service.impl;

import com.demo03.entity.CompanyEntity;
import com.demo03.dao.CompanyDao;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo03.service.CompanyService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyDao companyDao;

    @Autowired
    public CompanyServiceImpl(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    @Override
    @Transactional(readOnly = true)
    public JSONArray getCompanyByProvince(String province) {
        List<CompanyEntity> resultList = companyDao.getData(province);
        System.out.println(resultList.toString());
        JSONArray jsonArray = new JSONArray();
        for (CompanyEntity companyEntity : resultList) {
            JSONObject json = createJsonObj(companyEntity);
            jsonArray.add(json);
        }
        return jsonArray;
    }

    @SuppressWarnings("Duplicates")
    private JSONObject createJsonObj(CompanyEntity companyEntity) {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("name", companyEntity.getName());
        jsonObject.put("code", companyEntity.getCode());
        jsonObject.put("address", companyEntity.getAddress());
        jsonObject.put("X", companyEntity.getLocationX());
        jsonObject.put("Y", companyEntity.getLocationY());
        jsonObject.put("province", companyEntity.getProvince());
        return jsonObject;
    }
}
