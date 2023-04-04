package com.teh.retrofitlearning.models;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HotUpdateValue {
    // Name, Link_Manga, Image, Month_Update;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Link_Manga")
    @Expose
    private String linkManga;
    @SerializedName("Image")
    @Expose
    private String image;
    @SerializedName("Month_Update")
    @Expose
    private String monthUpdate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLinkManga() {
        return linkManga;
    }

    public void setLinkManga(String linkManga) {
        this.linkManga = linkManga;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMonthUpdate() {
        return monthUpdate;
    }

    public void setMonthUpdate(String monthUpdate) {
        this.monthUpdate = monthUpdate;
    }

    @NonNull
    @Override
    public String toString() {
        return "HotUpdateValue{" +
                "name='" + name + '\'' +
                ", linkManga='" + linkManga + '\'' +
                ", image='" + image + '\'' +
                ", monthUpdate='" + monthUpdate + '\'' +
                '}';
    }
}
