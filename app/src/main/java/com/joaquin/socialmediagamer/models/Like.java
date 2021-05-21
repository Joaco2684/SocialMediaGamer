package com.joaquin.socialmediagamer.models;

public class Like {

    private String idPost;
    private String idUser;
    private String id;
    private long timestamp;

    public Like() {

    }

    public Like(String idPost, String idUser, String id, long timestamp) {
        this.idPost = idPost;
        this.idUser = idUser;
        this.id = id;
        this.timestamp = timestamp;
    }

    public String getIdPost() {
        return idPost;
    }

    public void setIdPost(String idPost) {
        this.idPost = idPost;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
