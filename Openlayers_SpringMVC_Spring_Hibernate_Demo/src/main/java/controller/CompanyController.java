package controller;

import entity.CompanyEntity;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.CompanyService;

import java.util.List;

@Controller
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    private JSONArray jsonArray = new JSONArray();

    @RequestMapping("/get")
    public @ResponseBody String get(@RequestParam String province) {
        List<CompanyEntity> beansList = companyService.getData(province);

        for (CompanyEntity companyEntity : beansList) {
            JSONObject jsonObj = createJsonObj(companyEntity);
            jsonArray.add(jsonObj);
        }
        return jsonArray.toString();
    }

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
