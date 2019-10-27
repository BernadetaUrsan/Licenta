package com.example.licenta.Models;

public class ParkingsPosts {
    private String title;
    private String message;
    private String date;
    private String hour;

    public ParkingsPosts(String title, String message, String date, String hour) {
        this.title = title;
        this.message = message;
        this.date = date;
        this.hour = hour;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }
}
