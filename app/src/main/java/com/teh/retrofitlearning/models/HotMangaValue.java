package com.teh.retrofitlearning.models;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HotMangaValue {
    @SerializedName("Name_hot")
    @Expose
    private String nameHot;
    @SerializedName("Image_hot")
    @Expose
    private String imageHot;
    @SerializedName("Chapter_hot")
    @Expose
    private String chapterHot;

    public String getNameHot() {
        return nameHot;
    }

    public void setNameHot(String nameHot) {
        this.nameHot = nameHot;
    }

    public String getImageHot() {
        return imageHot;
    }

    public void setImageHot(String imageHot) {
        this.imageHot = imageHot;
    }

    public String getChapterHot() {
        return chapterHot;
    }

    public void setChapterHot(String chapterHot) {
        this.chapterHot = chapterHot;
    }
    @NonNull
    @Override
    public String toString() {
        return "HotMangaValue{" +
                "nameHot='" + nameHot + '\'' +
                ", imageHot='" + imageHot + '\'' +
                ", chapterHot='" + chapterHot + '\'' +
                '}';
    }
}
