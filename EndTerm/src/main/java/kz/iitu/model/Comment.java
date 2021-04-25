package kz.iitu.model;

import java.io.Serializable;

public class Comment implements Serializable {
    private int id,postId,userId;
    private String comment;
    private Users user;

    public Comment(int id, int postId, int userId, String comment, Users user) {
        this.id = id;
        this.postId = postId;
        this.userId = userId;
        this.comment = comment;
        this.user = user;
    }

    public Comment(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}

