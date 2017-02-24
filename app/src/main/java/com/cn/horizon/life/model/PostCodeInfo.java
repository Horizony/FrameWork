package com.cn.horizon.life.model;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by horizony on 2016/11/18.
 */

public class PostCodeInfo {
    @JsonProperty("PostNumber")
    private String postNumber;
    @JsonProperty("Province")
    private String province;
    @JsonProperty("City")
    private String city;
    @JsonProperty("District")
    private String district;
    @JsonProperty("Address")
    private String address;
    public void setPostNumber(String postNumber) {
        this.postNumber = postNumber;
    }
    public String getPostNumber() {
        return postNumber;
    }

    public void setProvince(String province) {
        this.province = province;
    }
    public String getProvince() {
        return province;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public String getCity() {
        return city;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
    public String getDistrict() {
        return district;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getAddress() {
        return address;
    }
}


