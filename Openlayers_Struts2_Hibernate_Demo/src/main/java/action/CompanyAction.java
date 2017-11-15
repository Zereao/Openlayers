package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.CompanyDao;
import entity.Entity;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.List;

public class CompanyAction extends ActionSupport {
    private String province;
    private String result;

    JSONArray jsonArray = new JSONArray();

    @Override
    public String execute() throws Exception {
        CompanyDao dao = new CompanyDao();
        List<Entity> resultList = dao.getData(province);

        for(Entity companyEntity : resultList){
            JSONObject jsonObj = createJsonObj(companyEntity);
            jsonArray.add(jsonObj);
        }
        result = jsonArray.toString();
        return SUCCESS;
    }

    public String getResult(){
        return jsonArray.toString();
    }

    public void setResult(String result) {
        this.result = result;
    }

    private JSONObject createJsonObj(Entity companyEntity){
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("name",companyEntity.getName());
        jsonObject.put("code", companyEntity.getCode());
        jsonObject.put("address", companyEntity.getAddress());
        jsonObject.put("X", companyEntity.getLocationX());
        jsonObject.put("Y", companyEntity.getLocationY());
        jsonObject.put("province", companyEntity.getProvince());
        return jsonObject;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
