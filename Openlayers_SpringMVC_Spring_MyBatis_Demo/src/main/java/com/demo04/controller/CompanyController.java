package com.demo04.controller;


import com.demo04.service.CompanyService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/company")
public class CompanyController {
    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @RequestMapping("/get")
    @ResponseBody
    public String get(@RequestParam("province") String province) {
        JSONArray jsonArray = companyService.getCompanyByProvince(province);
        return jsonArray.toString();
    }
}
