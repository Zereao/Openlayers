package service;

import entity.CompanyEntity;

import java.util.List;

public interface CompanyService {
    List<CompanyEntity> getData(String province);
}
