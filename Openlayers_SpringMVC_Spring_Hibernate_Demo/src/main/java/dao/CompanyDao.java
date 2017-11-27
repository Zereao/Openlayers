package dao;

import entity.CompanyEntity;

import java.util.List;

public interface CompanyDao {
    List<CompanyEntity> getData(String province);
}
