package com.hyl.model;

public class CompanyBean {
    private Integer id;

    private String name;

    private Integer code;

    private String address;

    private Float locationx;

    private Float locationy;

    private String province;

    public CompanyBean(Integer id, String name, Integer code, String address, Float locationx, Float locationy, String province) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.address = address;
        this.locationx = locationx;
        this.locationy = locationy;
        this.province = province;
    }

    public CompanyBean() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Float getLocationx() {
        return locationx;
    }

    public void setLocationx(Float locationx) {
        this.locationx = locationx;
    }

    public Float getLocationy() {
        return locationy;
    }

    public void setLocationy(Float locationy) {
        this.locationy = locationy;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    @Override
    public String toString() {
        return "CompanyBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code=" + code +
                ", address='" + address + '\'' +
                ", locationx=" + locationx +
                ", locationy=" + locationy +
                ", province='" + province + '\'' +
                '}';
    }
}