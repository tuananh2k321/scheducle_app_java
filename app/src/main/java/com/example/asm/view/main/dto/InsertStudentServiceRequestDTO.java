package com.example.asm.view.main.dto;

public class InsertStudentServiceRequestDTO {
    private String service;
    private String image;
    private String studentCodeID;
    private String phoneNumber;
    private String note;
    private int quantity;


    public InsertStudentServiceRequestDTO() {
    }

    public InsertStudentServiceRequestDTO(String service, String image, String studentCodeID, String phoneNumber, String note, int quantity) {
        this.service = service;
        this.image = image;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
