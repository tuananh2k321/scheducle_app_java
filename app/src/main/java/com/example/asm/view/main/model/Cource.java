package com.example.asm.view.main.model;

public class Cource {
    private int id;
    private String ngay, phong,
            giangDuong, maMon,
            mon, lop, giangVien,
            ca, thoiGianBatDau, thoiGianKetThuc, linkTrucTuyen;

    public Cource(int id, String ngay, String phong, String giangDuong, String maMon,
                  String mon, String lop, String giangVien,
                  String ca, String thoiGianBatDau, String thoiGianKetThuc,
                  String linkTrucTuyen) {
        this.id = id;
        this.ngay = ngay;
        this.phong = phong;
        this.giangDuong = giangDuong;
        this.maMon = maMon;
        this.mon = mon;
        this.lop = lop;
        this.giangVien = giangVien;
        this.ca = ca;
        this.thoiGianBatDau = thoiGianBatDau;
        this.thoiGianKetThuc = thoiGianKetThuc;
        this.linkTrucTuyen = linkTrucTuyen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String getPhong() {
        return phong;
    }

    public void setPhong(String phong) {
        this.phong = phong;
    }

    public String getGiangDuong() {
        return giangDuong;
    }

    public void setGiangDuong(String giangDuong) {
        this.giangDuong = giangDuong;
    }

    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public String getMon() {
        return mon;
    }

    public void setMon(String mon) {
        this.mon = mon;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getGiangVien() {
        return giangVien;
    }

    public void setGiangVien(String giangVien) {
        this.giangVien = giangVien;
    }

    public String getCa() {
        return ca;
    }

    public void setCa(String ca) {
        this.ca = ca;
    }

    public String getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(String thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public String getThoiGianKetThuc() {
        return thoiGianKetThuc;
    }

    public void setThoiGianKetThuc(String thoiGianKetThuc) {
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    public String getLinkTrucTuyen() {
        return linkTrucTuyen;
    }

    public void setLinkTrucTuyen(String linkTrucTuyen) {
        this.linkTrucTuyen = linkTrucTuyen;
    }
}
