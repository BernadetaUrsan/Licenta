package com.example.licenta.Models;

import java.io.Serializable;

public class CalendarRowModel implements Serializable {

    private String title;
        private String location;
        private String startTime;
        private String date;

    public CalendarRowModel(){

    }

    public CalendarRowModel(String title, String location, String startTime, String date) {
        this.title = title;
        this.location = location;
        this.startTime = startTime;
        this.date = date;
    }

    public CalendarRowModel(CalendarRowModel calendarRowModel){
        title = calendarRowModel.getTitle();
        location = calendarRowModel.getLocation();
        startTime = calendarRowModel.getStartTime();
        date = calendarRowModel.getDate();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
