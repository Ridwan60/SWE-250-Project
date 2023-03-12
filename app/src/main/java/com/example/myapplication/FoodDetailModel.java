package com.example.myapplication;

public class FoodDetailModel {
    int img, foodPrice;
    String foodName;

    public FoodDetailModel(int img, int foodPrice, String foodName) {
        this.img = img;
        this.foodPrice = foodPrice;
        this.foodName = foodName;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(int foodPrice) {
        this.foodPrice = foodPrice;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
}
