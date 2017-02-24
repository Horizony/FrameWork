package com.cn.horizon.life.http.bean;
import com.google.gson.JsonObject;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by horizon on 2016/7/19:36
 */
public class HttpResult<T> {
    private String reason;
    @JsonProperty("result")
    private T result;
    @JsonProperty("error_code")
    private int errorCode;
    @JsonProperty("resultcode")
    private int resultCode;


    public void setReason(String reason) {
        this.reason = reason;
    }
    public String getReason() {
        return reason;
    }
    public T getResult() {
        return result;
    }
    public void setResult(T result) {
        this.result = result;
    }
    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
    public int getErrorCode() {
        return errorCode;
    }
    public int getResultCode() {
        return resultCode;
    }
    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }
}
