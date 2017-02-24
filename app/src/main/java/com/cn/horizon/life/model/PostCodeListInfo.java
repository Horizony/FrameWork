package com.cn.horizon.life.model;

import java.util.List;

/**
 * Created by horizony on 2016/11/18.
 */

public class PostCodeListInfo {
    private List<PostCodeInfo> list;
    private int totalcount;
    private int totalpage;
    private int currentpage;
    private String pagesize;
    public void setList(List<PostCodeInfo> list) {
        this.list = list;
    }
    public List<PostCodeInfo> getList() {
        return list;
    }

    public void setTotalcount(int totalcount) {
        this.totalcount = totalcount;
    }
    public int getTotalcount() {
        return totalcount;
    }

    public void setTotalpage(int totalpage) {
        this.totalpage = totalpage;
    }
    public int getTotalpage() {
        return totalpage;
    }

    public void setCurrentpage(int currentpage) {
        this.currentpage = currentpage;
    }
    public int getCurrentpage() {
        return currentpage;
    }

    public void setPagesize(String pagesize) {
        this.pagesize = pagesize;
    }
    public String getPagesize() {
        return pagesize;
    }
}
