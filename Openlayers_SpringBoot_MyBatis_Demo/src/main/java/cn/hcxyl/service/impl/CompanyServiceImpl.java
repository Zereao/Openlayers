package cn.hcxyl.service.impl;

import cn.hcxyl.dao.CompanyDao;
import cn.hcxyl.model.CompanyEntity;
import cn.hcxyl.service.CompanyService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jupiter
 * @date 2018/04/24/19:40
 */
@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyDao companyDao;

    @Autowired
    public CompanyServiceImpl(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    @Override
    public JSONArray getCompanyByProvince(String province) {
        List<CompanyEntity> companyEntityList = companyDao.selectByProvince(province);
        JSONArray jsonArray = new JSONArray();
        for (CompanyEntity companyEntity : companyEntityList) {
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
        jsonObject.put("X", companyEntity.getX_intercept());
        jsonObject.put("Y", companyEntity.getY_intercept());
        jsonObject.put("province", companyEntity.getProvince());
        return jsonObject;
    }
}
