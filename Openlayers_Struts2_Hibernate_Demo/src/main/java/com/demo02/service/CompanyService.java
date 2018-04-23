package com.demo02.service;

import com.demo02.dao.CompanyDao;
import com.demo02.entity.CompanyEntity;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.List;

/**
 * @author Jupiter
 * @date 2018/04/19/16:51
 */
public class CompanyService {

    public JSONArray getInfoByProvince(String province) {
        CompanyDao companyDao = new CompanyDao();
        JSONArray jsonArray = new JSONArray();

        List<CompanyEntity> entityList = companyDao.getData(province);
        for (CompanyEntity companyEntity : entityList) {
            JSONObject json = convert2JsonObj(companyEntity);
            jsonArray.add(json);
        }
        return jsonArray;
    }

    private JSONObject convert2JsonObj(CompanyEntity companyEntity) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", companyEntity.getName());
        jsonObject.put("code", companyEntity.getCode());
        jsonObject.put("address", companyEntity.getAddress());
        jsonObject.put("X", companyEntity.getxIntercept());
        jsonObject.put("Y", companyEntity.getyIntercept());
        jsonObject.put("province", companyEntity.getProvince());
        return jsonObject;
    }
}
