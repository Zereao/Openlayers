package com.hyl.controller;


import com.hyl.model.CompanyBean;
import com.hyl.service.CompanyService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    private JSONArray jsonArray = new JSONArray();

    @RequestMapping("/get")
    public @ResponseBody String get(@RequestParam("province") String province){
        List<CompanyBean> beansList = companyService.getCompanyByProvince(province);

        for(CompanyBean companyBean : beansList){
            JSONObject jsonObj = createJsonObj(companyBean);
            jsonArray.add(jsonObj);
        }
        return jsonArray.toString();
    }

    private JSONObject createJsonObj(CompanyBean companyBean){
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("name",companyBean.getName());
        jsonObject.put("code", companyBean.getCode());
        jsonObject.put("address", companyBean.getAddress());
        jsonObject.put("X", companyBean.getLocationx());
        jsonObject.put("Y", companyBean.getLocationy());
        jsonObject.put("province", companyBean.getProvince());
        return jsonObject;
    }
}
