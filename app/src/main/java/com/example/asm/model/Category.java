package com.example.asm.model;

public class Category {
    private int id;
    private String name;
    private int img;
    private String color;




    public Category(int id, String name, int img, String color) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.color = color;
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

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }




}
