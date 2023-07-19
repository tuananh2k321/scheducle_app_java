package com.example.asm.view.main.model;

public class ServiceComplete {
    private String id,loai,thongbao,confirm,date;

    private boolean isExpanded;

    public ServiceComplete(String id, String loai, String thongbao, String confirm, String date) {
        this.id = id;
        this.loai = loai;
        this.thongbao = thongbao;
        this.confirm = confirm;
        this.date = date;
        this.isExpanded = false;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getThongbao() {
        return thongbao;
    }

    public void setThongbao(String thongbao) {
        this.thongbao = thongbao;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }
}
