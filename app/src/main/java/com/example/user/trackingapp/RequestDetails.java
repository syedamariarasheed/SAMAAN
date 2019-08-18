package com.example.user.trackingapp;

import com.google.android.gms.maps.model.LatLng;

public class RequestDetails {
    String Description_,Transport_,Time_,Weight_;
    String Location_;

    public RequestDetails(String description_, String transport_, String time_, String weight_, String location_) {
        Description_ = description_;
        Transport_ = transport_;
        Time_ = time_;
        Weight_ = weight_;
        Location_ = location_;
    }
public RequestDetails(){}
    public String getDescription_() {
        return Description_;
    }

    public void setDescription_(String description_) {
        Description_ = description_;
    }

    public String getTransport_() {
        return Transport_;
    }

    public void setTransport_(String transport_) {
        Transport_ = transport_;
    }

    public String getTime_() {
        return Time_;
    }

    public void setTime_(String time_) {
        Time_ = time_;
    }

    public String getWeight_() {
        return Weight_;
    }

    public void setWeight_(String weight_) {
        Weight_ = weight_;
    }

    public String getLocation_() {
        return Location_;
    }

    public void setLocation_(String location_) {
        Location_ = location_;
    }


}
