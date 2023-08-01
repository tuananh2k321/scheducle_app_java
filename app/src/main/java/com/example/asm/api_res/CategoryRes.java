package com.example.asm.api_res;

import com.example.asm.model.Category;

import java.util.ArrayList;

public class CategoryRes {
    private  String message;
    private  Boolean status ;

    public CategoryRes(String message, Boolean status, ArrayList<Category> categories) {
        this.message = message;
        this.status = status;
        this.categories = categories;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CategoryRes{" +
                "message='" + message + '\'' +
                ", status=" + status +
                ", categories=" + categories.toString() +
                '}';
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }

    private ArrayList<Category> categories;
}
