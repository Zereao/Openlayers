package com.demo01.dao;

import com.demo01.db.DBUtil;
import com.demo01.entity.CompanyEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CompanyDao {
    public List<CompanyEntity> getData(String province) throws Exception {
        ResultSet resultSet = null;
        String SQL = "SELECT od.id," +
                "od.name," +
                "od.code," +
                "od.address," +
                "od.x_intercept," +
                "od.y_intercept " +
                "FROM openlayers_company_info od " +
                "WHERE 1=1 " +
                "AND province LIKE '%" + province + "%'";
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        resultSet = preparedStatement.executeQuery();

        List<CompanyEntity> list = new ArrayList<>();
        CompanyEntity company = null;
        while (resultSet.next()) {
            company = new CompanyEntity();
            company.setId(resultSet.getInt("id"));
            company.setName(resultSet.getString("name"));
            company.setCode(resultSet.getInt("code"));
            company.setAddress(resultSet.getString("address"));
            company.setLocationX(resultSet.getDouble("x_intercept"));
            company.setLocationY(resultSet.getDouble("y_intercept"));
            company.setProvince(province);
            list.add(company);
        }
        resultSet.close();
        preparedStatement.close();
        return list;
    }
}
