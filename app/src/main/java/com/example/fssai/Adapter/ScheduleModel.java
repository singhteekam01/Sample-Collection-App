package com.example.fssai.Adapter;

import android.view.View;

import java.sql.Time;
import java.util.Date;

public class ScheduleModel {
    String city,fsoName,samplerName;
    String dateTime;
    String location;
    Integer status_view = 0;

    public ScheduleModel(String city, String fsoName, String dateTime, String location) {
        this.city = city;
        this.fsoName = fsoName;
        this.dateTime = dateTime;
        this.location = location;
    }

    public ScheduleModel(String city, String fsoName, String dateTime, String location, Integer status_view) {
        this.city = city;
        this.fsoName = fsoName;
        this.dateTime = dateTime;
        this.location = location;
        this.status_view = status_view;
    }

    public ScheduleModel(String city, String fsoName, String samplerName, String dateTime, String location) {
        this.city = city;
        this.fsoName = fsoName;
        this.samplerName = samplerName;
        this.dateTime = dateTime;
        this.location = location;
    }

    public String getSamplerName() {
        return samplerName;
    }

    public void setSamplerName(String samplerName) {
        this.samplerName = samplerName;
    }

    public Integer getStatus_view() {
        return status_view;
    }

    public void setStatus_view(Integer status_view) {
        this.status_view = status_view;
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
}
