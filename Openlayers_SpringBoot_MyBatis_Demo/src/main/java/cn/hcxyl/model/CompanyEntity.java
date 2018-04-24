package cn.hcxyl.model;

public class CompanyEntity {
    private Integer id;
    private String name;
    private Integer code;
    private String address;
    private Float x_intercept;
    private Float y_intercept;
    private String province;

    public CompanyEntity() {
    }

    public CompanyEntity(String name, Integer code, String address, Float x_intercept, Float y_intercept, String province) {
        this.name = name;
        this.code = code;
        this.address = address;
        this.x_intercept = x_intercept;
        this.y_intercept = y_intercept;
        this.province = province;
    }

    public CompanyEntity(Integer id, String name, Integer code, String address, Float x_intercept, Float y_intercept, String province) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.address = address;
        this.x_intercept = x_intercept;
        this.y_intercept = y_intercept;
        this.province = province;
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
        this.name = name;
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
        this.address = address;
    }

    public Float getX_intercept() {
        return x_intercept;
    }

    public void setX_intercept(Float x_intercept) {
        this.x_intercept = x_intercept;
    }

    public Float getY_intercept() {
        return y_intercept;
    }

    public void setY_intercept(Float y_intercept) {
        this.y_intercept = y_intercept;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return "CompanyEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code=" + code +
                ", address='" + address + '\'' +
                ", x_intercept=" + x_intercept +
                ", y_intercept=" + y_intercept +
                ", province='" + province + '\'' +
                '}';
    }
}