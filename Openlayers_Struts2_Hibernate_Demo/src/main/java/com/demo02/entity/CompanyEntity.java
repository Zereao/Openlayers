package com.demo02.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author Jupiter
 * @date 2018/04/19/15:56
 */
@Entity
@Table(name = "openlayers_company_info", schema = "learn_demos", catalog = "")
public class CompanyEntity {

    private int id;
    private String name;
    private String code;
    private String address;
    private String xIntercept;
    private String yIntercept;
    private String province;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "code", nullable = true, length = 255)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 255)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "x_intercept", nullable = true, length = 255)
    public String getxIntercept() {
        return xIntercept;
    }

    public void setxIntercept(String xIntercept) {
        this.xIntercept = xIntercept;
    }

    @Basic
    @Column(name = "y_intercept", nullable = true, length = 255)
    public String getyIntercept() {
        return yIntercept;
    }

    public void setyIntercept(String yIntercept) {
        this.yIntercept = yIntercept;
    }

    @Basic
    @Column(name = "province", nullable = true, length = 255)
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyEntity that = (CompanyEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(code, that.code) &&
                Objects.equals(address, that.address) &&
                Objects.equals(xIntercept, that.xIntercept) &&
                Objects.equals(yIntercept, that.yIntercept) &&
                Objects.equals(province, that.province);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, code, address, xIntercept, yIntercept, province);
    }
}
