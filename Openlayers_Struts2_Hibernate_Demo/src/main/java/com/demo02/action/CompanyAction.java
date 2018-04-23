package com.demo02.action;

import com.demo02.service.CompanyService;
import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONArray;

public class CompanyAction extends ActionSupport {
    private String province;
    private String result;

    @Override
    public String execute() {
        CompanyService companyService = new CompanyService();
        JSONArray jsonArray = companyService.getInfoByProvince(province);
        result = jsonArray.toString();
        return SUCCESS;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
