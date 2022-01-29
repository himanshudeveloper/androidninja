package com.example.androidninjaworkspace.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class data {

    @SerializedName("page")
    @Expose
    private String page;
    @SerializedName("per_page")
    @Expose
    private String per_page;

     @SerializedName("total")
    @Expose
    private String total;
     @SerializedName("total_pages")
    @Expose
    private String total_pages;
    @SerializedName("data")
    @Expose
     private models data;
    @SerializedName("status")
    @Expose
    private boolean status;
    @SerializedName("message")
    @Expose
    private String message;


    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getPer_page() {
        return per_page;
    }

    public void setPer_page(String per_page) {
        this.per_page = per_page;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(String total_pages) {
        this.total_pages = total_pages;
    }

    public models getData() {
        return data;
    }

    public void setData(models data) {
        this.data = data;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
