package kz.iitu.model;

import java.io.Serializable;
import java.util.List;

public class Post implements Serializable{
    private int id,like,dislike,userId;
    private String topic,text;
    private Users user;
    private List<Comment> comments;

    public Post(){}

    public Post(int id, int like, int dislike, int userId, String topic, String text, Users user) {
        this.id = id;
        this.like = like;
        this.dislike = dislike;
        this.userId = userId;
        this.topic = topic;
        this.text = text;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getDislike() {
        return dislike;
    }

    public void setDislike(int dislike) {
        this.dislike = dislike;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}

