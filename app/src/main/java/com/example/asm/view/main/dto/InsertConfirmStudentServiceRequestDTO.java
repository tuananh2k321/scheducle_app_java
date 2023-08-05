package com.example.asm.view.main.dto;

public class InsertConfirmStudentServiceRequestDTO {
    private String service;
    private String studentCodeID;
    private String phoneNumber;
    private String note;
    private String mucdich;
    private String confirm;
    private int quantity;

    public InsertConfirmStudentServiceRequestDTO() {
    }

    public InsertConfirmStudentServiceRequestDTO(String service, String studentCodeID, String phoneNumber, String note, String mucdich, String confirm, int quantity) {
        this.service = service;
        this.studentCodeID = studentCodeID;
        this.phoneNumber = phoneNumber;
        this.note = note;
        this.mucdich = mucdich;
        this.confirm = confirm;
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

    public String getMucdich() {
        return mucdich;
    }

    public void setMucdich(String mucdich) {
        this.mucdich = mucdich;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
