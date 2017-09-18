package controller;

import dao.CompanyDao;
import entity.Entity;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "CompanyServlet",urlPatterns = "/controller/CompanyServlet")
public class CompanyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String province = request.getParameter("province");

        CompanyDao service = new CompanyDao();
        List<Entity> list = service.getData(province);

        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        JSONArray jsonArray = new JSONArray();
        PrintWriter out = response.getWriter();
        for (Entity companyEntity : list) {
            JSONObject object = createJsonObj(companyEntity);
            jsonArray.add(object);
        }
        out.print(jsonArray);
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


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
