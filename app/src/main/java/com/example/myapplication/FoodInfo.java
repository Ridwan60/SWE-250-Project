package com.example.myapplication;

public class FoodInfo {


    String name, type, imageUri;
    int price;

    public FoodInfo(String name, int price, String type, String imageUri) {
        this.name = name;
        this.type = type;
        this.imageUri = imageUri;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
