package com.example.asm.model;

public class Category {
    private int id;
    private String name;
    private String image;
    private String bgColor;


    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", img='" + image + '\'' +
                ", color='" + bgColor + '\'' +
                '}';
    }

    public Category(int id, String name, String img, String color) {
        this.id = id;
        this.name = name;
        this.image = img;
        this.bgColor = color;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return image;
    }

    public void setImg(String img) {
        this.image = img;
    }

    public String getColor() {
        return bgColor;
    }

    public void setColor(String color) {
        this.bgColor = color;
    }




}
