package servlet;

import entity.CompanyEntity;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import service.CompanyService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "CompanyServlet",urlPatterns = "/servlet/CompanyServlet")
public class CompanyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String province = request.getParameter("province");

        CompanyService service = new CompanyService();
        List<CompanyEntity> list = service.query(province);

        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        JSONArray jsonArray = new JSONArray();
        PrintWriter out = response.getWriter();
        for (CompanyEntity companyEntity : list) {
            JSONObject object = createJsonObj(companyEntity);
            jsonArray.add(object);
        }
        out.print(jsonArray);
    }

    private JSONObject createJsonObj(CompanyEntity companyEntity){
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
