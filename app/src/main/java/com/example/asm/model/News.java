package com.example.asm.model;

public class News {
    private int id;
    private String title;
    private String detail;
    private String image;

    private int isSeen;
    private int categoryId;
    public News(int id, String title, String detail, String img, int isSeen, int categoryId) {
        this.id = id;
        this.title = title;
        this.detail = detail;
        this.image = img;
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

    public String getImg() {
        return image;
    }

    public void setImg(String img) {
        this.image = img;
    }

    public int getSeen() {
        return isSeen;
    }

    public void setSeen(int seen) {
        isSeen = seen;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
