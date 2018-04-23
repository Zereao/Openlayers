package com.demo03.dao;

import com.demo03.entity.CompanyEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyDao {
    List<CompanyEntity> getData(String province);
}
