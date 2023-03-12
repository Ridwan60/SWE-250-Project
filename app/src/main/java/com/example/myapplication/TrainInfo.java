package com.example.myapplication;

public class TrainInfo {

    String name, dateofJourney, chooseClass, bogi, seat, imageUri;

    public TrainInfo(String name, String dateofJourney, String chooseClass, String bogi, String seat, String imageUri) {
        this.name = name;
        this.dateofJourney = dateofJourney;
        this.chooseClass = chooseClass;
        this.bogi = bogi;
        this.seat = seat;
        this.imageUri = imageUri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateofJourney() {
        return dateofJourney;
    }

    public void setDateofJourney(String dateofJourney) {
        this.dateofJourney = dateofJourney;
    }

    public String getChooseClass() {
        return chooseClass;
    }

    public void setChooseClass(String chooseClass) {
        this.chooseClass = chooseClass;
    }

    public String getBogi() {
        return bogi;
    }

    public void setBogi(String bogi) {
        this.bogi = bogi;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }
}
