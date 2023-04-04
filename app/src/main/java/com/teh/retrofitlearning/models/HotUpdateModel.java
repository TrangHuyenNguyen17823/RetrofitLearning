package com.teh.retrofitlearning.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HotUpdateModel {
    @SerializedName("Hot_Update")
    private List<HotUpdateValue> hotUpdate;

    public List<HotUpdateValue> getHotUpdate() {
        return hotUpdate;
    }

    public void setHotUpdate(List<HotUpdateValue> hotUpdate) {
        this.hotUpdate = hotUpdate;
    }
}
