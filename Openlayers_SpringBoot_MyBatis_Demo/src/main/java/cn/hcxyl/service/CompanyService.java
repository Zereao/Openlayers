package cn.hcxyl.service;

import net.sf.json.JSONArray;
import org.springframework.stereotype.Service;

/**
 * @author Jupiter
 * @date 2018/04/24/19:40
 */
@Service
public interface CompanyService {

    JSONArray getCompanyByProvince(String province);
}
