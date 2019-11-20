package com.example.licenta.Models;

import java.util.Date;
import java.util.List;

public class PostModel {
    private String title;
    private String message;
    private Date date;
    private StudentModel author;
    private List<CommentModel> comments;

    public PostModel(String title, String message, Date date, StudentModel author, List<CommentModel> comments) {
        this.title = title;
        this.message = message;
        this.date = date;
        this.author = author;
        this.comments = comments;
    }

    public PostModel() {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public StudentModel getAuthor() {
        return author;
    }

    public void setAuthor(StudentModel author) {
        this.author = author;
    }

    public List<CommentModel> getComments() {
        return comments;
    }

    public void setComments(List<CommentModel> comments) {
        this.comments = comments;
    }
}
