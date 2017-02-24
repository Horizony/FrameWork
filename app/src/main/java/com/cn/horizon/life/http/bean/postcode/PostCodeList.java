package com.cn.horizon.life.http.bean.postcode;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

/**
 * Created by horizony on 2016/11/21.
 */

public class PostCodeList {
    private List<PostCodeItem> list;
    @JsonProperty("totalcount")
    private int totalCount;
    @JsonProperty("totalpage")
    private int totalPage;
    @JsonProperty("currentpage")
    private int currentPage;
    @JsonProperty("pagesize")
    private String pageSize;
    public void setList(List<PostCodeItem> list) {
        this.list = list;
    }
    public List<PostCodeItem> getList() {
        return list;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
    public int getTotalPage() {
        return totalPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    public int getCurrentPage() {
        return currentPage;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }
    public String getPageSize() {
        return pageSize;
    }
}
