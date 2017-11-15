package dao;

import db.DBUtil;
import entity.CompanyEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CompanyDao {
    ResultSet resultSet = null;
    public List<CompanyEntity> getData(String province) throws Exception{
        String SQL = "SELECT od.id," +
                            "od.name," +
                            "od.code," +
                            "od.address," +
                            "od.locationX," +
                            "od.locationY " +
                     "FROM openlayers_demo od " +
                     "WHERE 1=1 " +
                     "AND province = '" + province +"'";
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        resultSet = preparedStatement.executeQuery();

        List<CompanyEntity> list = new ArrayList<>();
        CompanyEntity company = null;
        while (resultSet.next()){
            company = new CompanyEntity();
            company.setId(resultSet.getInt("id"));
            company.setName(resultSet.getString("name"));
            company.setCode(resultSet.getInt("code"));
            company.setAddress(resultSet.getString("address"));
            company.setLocationX(resultSet.getDouble("locationX"));
            company.setLocationY(resultSet.getDouble("locationY"));
            company.setProvince(province);
            list.add(company);
        }
        resultSet.close();
        preparedStatement.close();
        return list;
    }
}
