package com.teh.retrofitlearning.models;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LatestUpdateValue {
    //Name, Chapter_Update, Time_Update;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Chapter_Update")
    @Expose
    private String chapterUpdate;
    @SerializedName("Time_Update")
    @Expose
    private String timeUpdate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChapterUpdate() {
        return chapterUpdate;
    }

    public void setChapterUpdate(String chapterUpdate) {
        this.chapterUpdate = chapterUpdate;
    }

    public String getTimeUpdate() {
        return timeUpdate;
    }

    public void setTimeUpdate(String timeUpdate) {
        this.timeUpdate = timeUpdate;
    }

    @NonNull
    @Override
    public String toString() {
        return "LatestUpdateValue{" +
                "name='" + name + '\'' +
                ", chapterUpdate='" + chapterUpdate + '\'' +
                ", timeUpdate='" + timeUpdate + '\'' +
                '}';
    }
}
