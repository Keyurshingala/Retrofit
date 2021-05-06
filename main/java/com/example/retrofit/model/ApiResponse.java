package com.example.retrofit.model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class ApiResponse {

    private int page;
    @SerializedName("per_page")
    private int perPage;
    private int total;
    @SerializedName("total_pages")
    private int totalPage;

    @SerializedName("data")
    private ArrayList<User> userList;

    private Support support;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public ArrayList<User> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }

    public Support getSupport() {
        return support;
    }

    public void setSupport(Support support) {
        this.support = support;
    }
}
