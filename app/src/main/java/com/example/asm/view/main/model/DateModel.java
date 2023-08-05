package com.example.asm.view.main.model;

public class DateModel {
    private int id,ngay;
    private String thu;
    private String ngayThangNam;

    public boolean isSelected;

    public DateModel() {
    }

    public DateModel(int id, int ngay, String thu, String ngayThangNam) {
        this.id = id;
        this.ngay = ngay;
        this.thu = thu;
        this.ngayThangNam = ngayThangNam;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNgay() {
        return ngay;
    }

    public void setNgay(int ngay) {
        this.ngay = ngay;
    }

    public String getThu() {
        return thu;
    }

    public void setThu(String thu) {
        this.thu = thu;
    }

    public String getNgayThangNam() {
        return ngayThangNam;
    }

    public void setNgayThangNam(String ngayThangNam) {
        this.ngayThangNam = ngayThangNam;
    }
}
