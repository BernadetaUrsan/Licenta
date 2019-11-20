package com.example.licenta.Models;

import java.util.Date;

public class CommentModel {

    private String fullName;
    private String message;
    private Date date;

    public CommentModel() {
    }

    public CommentModel(String fullName, String message, Date date) {
        this.fullName = fullName;
        this.message = message;
        this.date = date;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
