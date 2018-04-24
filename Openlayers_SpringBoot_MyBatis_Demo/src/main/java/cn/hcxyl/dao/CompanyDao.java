package cn.hcxyl.dao;

import cn.hcxyl.model.CompanyEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Jupiter
 * @date 2018/04/24/19:45
 */
@Mapper
public interface CompanyDao {
    @Select("<script>" +
            "   SELECT * " +
            "   FROM openlayers_company_info " +
            "   WHERE province = #{province,jdbcType=VARCHAR}" +
            "</script>")
    @ResultMap("cn.hcxyl.dao.CompanyDao.BaseResultMap")
    List<CompanyEntity> selectByProvince(@Param("province") String province);
}
