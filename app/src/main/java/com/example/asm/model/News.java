package com.example.asm.model;

public class News {
    private int id;
    private String title;
    private String detail;
    private int img;
    private int categoryId;
    public News(int id, String title, String detail, int img, int categoryId) {
        this.id = id;
        this.title = title;
        this.detail = detail;
        this.img = img;
        this.categoryId = categoryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getImage() {
        return img;
    }

    public void setImage(int img) {
        this.img = img;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
