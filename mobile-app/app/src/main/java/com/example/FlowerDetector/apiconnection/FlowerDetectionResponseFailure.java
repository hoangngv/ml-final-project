package com.example.FlowerDetector.apiconnection;

import com.google.gson.annotations.SerializedName;

public class FlowerDetectionResponseFailure {
    @SerializedName("mess")
    private String mess;

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }
}