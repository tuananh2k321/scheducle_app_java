package com.example.asm.view.main.dto;

public class InsertBangDiemServiceRequestDTO {
    private String service;
    private String studentCodeID;
    private String phoneNumber;
    private String note;
    private int quantity;

    public InsertBangDiemServiceRequestDTO() {
    }

    public InsertBangDiemServiceRequestDTO(String service, String studentCodeID, String phoneNumber, String note, int quantity) {
        this.service = service;
        this.studentCodeID = studentCodeID;
        this.phoneNumber = phoneNumber;
        this.note = note;
        this.quantity = quantity;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getStudentCodeID() {
        return studentCodeID;
    }

    public void setStudentCodeID(String studentCodeID) {
        this.studentCodeID = studentCodeID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
