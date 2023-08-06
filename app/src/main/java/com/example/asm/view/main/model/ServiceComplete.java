package com.example.asm.view.main.model;

public class ServiceComplete {
    private int id;
    private String service;
    private String phoneNumber;
    private String confirm;
    private String mucdich;
    private int quantity;
    private boolean isExpanded;

    public ServiceComplete() {
    }

    public ServiceComplete(int id, String service, String phoneNumber, String confirm, String mucdich, int quantity) {
        this.id = id;
        this.service = service;
        this.phoneNumber = phoneNumber;
        this.confirm = confirm;
        this.mucdich = mucdich;
        this.quantity = quantity;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public String getMucdich() {
        return mucdich;
    }

    public void setMucdich(String mucdich) {
        this.mucdich = mucdich;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }
}
