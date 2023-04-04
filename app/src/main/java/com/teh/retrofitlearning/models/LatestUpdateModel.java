package com.teh.retrofitlearning.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LatestUpdateModel {
    @SerializedName("Latest_Update")
    @Expose
    private List<LatestUpdateValue> latestUpdate;

    public List<LatestUpdateValue> getLatestUpdate() {
        return latestUpdate;
    }

    public void setLatestUpdate(List<LatestUpdateValue> latestUpdate) {
        this.latestUpdate = latestUpdate;
    }
}
