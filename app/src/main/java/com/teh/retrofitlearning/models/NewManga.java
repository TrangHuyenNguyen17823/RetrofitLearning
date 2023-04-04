package com.teh.retrofitlearning.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewManga {
    @SerializedName("New Manga")
    @Expose
    private List<NewMangaValue> newManga;

    public List<NewMangaValue> getNewManga() {
        return newManga;
    }

    public void setNewManga(List<NewMangaValue> newManga) {
        this.newManga = newManga;
    }
}
