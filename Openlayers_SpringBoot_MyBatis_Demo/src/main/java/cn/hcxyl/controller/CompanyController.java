package cn.hcxyl.controller;

import cn.hcxyl.service.CompanyService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jupiter
 * @date 2018/04/24/19:37
 */
@RestController
@RequestMapping("/company")
public class CompanyController {
    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @RequestMapping("get")
    public String get(@RequestParam("province") String province) {
        JSONArray jsonArray = companyService.getCompanyByProvince(province);
        return jsonArray.toString();
    }
}
