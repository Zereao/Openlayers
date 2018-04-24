package com.demo04.dao;


import com.demo04.model.CompanyEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CompanyDao {
    @Select("<script>" +
            "   SELECT * " +
            "   FROM openlayers_company_info " +
            "   WHERE province = #{province,jdbcType=VARCHAR}" +
            "</script>")
    @ResultMap("com.demo04.dao.CompanyDao.BaseResultMap")
    List<CompanyEntity> selectByProvince(@Param("province") String province);
}