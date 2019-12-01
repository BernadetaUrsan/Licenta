package com.example.licenta.Models;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class PostModel {
    private String id;
    private String title;
    private String message;
    private Date date;
    private String authorName;
    private List<CommentModel> comments;

    public PostModel(String id, String title, String message, Date date, String author, List<CommentModel> comments) {
        this.title = title;
        this.message = message;
        this.date = date;
        this.authorName = author;
        this.comments = comments;
        this.id = id;
    }

    public PostModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public List<CommentModel> getComments() {
        return comments;
    }

    public void setComments(List<CommentModel> comments) {
        this.comments = comments;
    }
}
