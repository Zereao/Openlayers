package com.demo01.service;

import com.demo01.dao.CompanyDao;
import com.demo01.entity.CompanyEntity;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.List;

public class CompanyService {
    public JSONArray query(String Province) {
        try {
            CompanyDao dao = new CompanyDao();
            List<CompanyEntity> entityList = dao.getData(Province);
            JSONArray jsonArray = new JSONArray();
            for (CompanyEntity companyEntity : entityList) {
                JSONObject object = convert2JsonObj(companyEntity);
                jsonArray.add(object);
            }
            return jsonArray;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private JSONObject convert2JsonObj(CompanyEntity companyEntity) {
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
