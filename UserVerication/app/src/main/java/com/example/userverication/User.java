package com.example.userverication;

public class User {
    private String userName, userEmail;
    private int userImage;
    private boolean isVerified;

    public User() {

    }

    public User(String userName, String userEmail, int userImage, boolean isVerified) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userImage = userImage;
        this.isVerified = isVerified;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public int getUserImage() {
        return userImage;
    }

    public boolean isVerified() {
        return isVerified;
    }
}
