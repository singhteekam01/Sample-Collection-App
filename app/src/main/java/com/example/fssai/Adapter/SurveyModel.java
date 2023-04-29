package com.example.fssai.Adapter;

import android.widget.CheckBox;

public class SurveyModel {

    String city,fsoName;
    String dateTime;
    String location;
    boolean selected;


    public SurveyModel(boolean selected) {
        this.selected = selected;
    }

    public SurveyModel() {
    }

    public SurveyModel(String city, String fsoName, String dateTime, String location, boolean selected) {
        this.city = city;
        this.fsoName = fsoName;
        this.dateTime = dateTime;
        this.location = location;
        this.selected = selected;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFsoName() {
        return fsoName;
    }

    public void setFsoName(String fsoName) {
        this.fsoName = fsoName;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
