package com.example.asm.view.main.model;

public class ServiceComplete {
    private int id;
    private String service;
    private String date;
    private String confirm;
    private String thongbao;
    private boolean isExpanded;

    public ServiceComplete() {
    }

    public ServiceComplete(int id, String service, String date, String confirm, String thongbao) {
        this.id = id;
        this.service = service;
        this.date = date;
        this.confirm = confirm;
        this.thongbao = thongbao;
        this.isExpanded = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public String getThongbao() {
        return thongbao;
    }

    public void setThongbao(String thongbao) {
        this.thongbao = thongbao;
    }

    public boolean isExpanded() {
        return isExpanded;
    }


    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }
}
