package com.example.myapplication.entity;

public class ItemsModel {
    String name,email;
    int image;

    public ItemsModel() {
    }

    public ItemsModel(String name, String email, int image) {
        this.name = name;
        this.email = email;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
