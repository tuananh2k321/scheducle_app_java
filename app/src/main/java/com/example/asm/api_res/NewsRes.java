package com.example.asm.api_res;

import com.example.asm.model.News;

import java.util.ArrayList;

public class NewsRes {
    private  String message;
    private  Boolean status ;
    private ArrayList<News> news;

    private ArrayList<News> notification;

    private News oneNews;

    public NewsRes(String message, Boolean status, ArrayList<News> news, ArrayList<News> notification, News oneNews) {
        this.message = message;
        this.status = status;
        this.news = news;
        this.notification = notification;
        this.oneNews = oneNews;
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

    public ArrayList<News> getNews() {
        return news;
    }

    public void setNews(ArrayList<News> news) {
        this.news = news;
    }

    public ArrayList<News> getNotification() {
        return notification;
    }

    public void setNotification(ArrayList<News> notification) {
        this.notification = notification;
    }

    public News getOneNews() {
        return oneNews;
    }

    public void setOneNews(News oneNews) {
        this.oneNews = oneNews;
    }

    @Override
    public String toString() {
        return "NewsRes{" +
                "message='" + message + '\'' +
                ", status=" + status +
                ", news=" + news +
                ", notification=" + notification +
                ", oneNews=" + oneNews +
                '}';
    }
}
