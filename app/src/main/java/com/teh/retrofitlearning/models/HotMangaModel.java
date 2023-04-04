package com.teh.retrofitlearning.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HotMangaModel {
    @SerializedName("Hot_Manga")
    @Expose
    private List<HotMangaValue> hotManga;

    public List<HotMangaValue> getHotManga() {
        return hotManga;
    }
}
