package com.example.asm.model;

public class News {
    private int id;
    private String title;
    private String detail;
    private int img;

    private Boolean isSeen;
    private int categoryId;
    public News(int id, String title, String detail, int img, Boolean isSeen, int categoryId) {
        this.id = id;
        this.title = title;
        this.detail = detail;
        this.img = img;
        this.isSeen = isSeen;
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

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public Boolean getSeen() {
        return isSeen;
    }

    public void setSeen(Boolean seen) {
        isSeen = seen;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
