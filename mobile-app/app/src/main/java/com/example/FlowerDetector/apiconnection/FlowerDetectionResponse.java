package com.example.FlowerDetector.apiconnection;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FlowerDetectionResponse {
    @SerializedName("flower_type")
    @Expose
    private String flowerType;

    @SerializedName("score")
    @Expose
    private float score;

    public String getFlowerType() {
        return flowerType;
    }

    public void setFlowerType(String flowerType) {
        this.flowerType = flowerType;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}
