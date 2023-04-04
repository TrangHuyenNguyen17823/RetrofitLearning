package com.teh.retrofitlearning.models;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewMangaValue {
    @SerializedName("Name_Manga_New")
    @Expose
    private String nameMangaNew;
    @SerializedName("Chapter_New")
    @Expose
    private String chapterNew;
    @SerializedName("Thumb")
    @Expose
    private String thumb;

    public String getNameMangaNew() {
        return nameMangaNew;
    }

    public String getChapterNew() {
        return chapterNew;
    }

    public String getThumb() {
        return thumb;
    }

    public void setNameMangaNew(String nameMangaNew) {
        this.nameMangaNew = nameMangaNew;
    }

    public void setChapterNew(String chapterNew) {
        this.chapterNew = chapterNew;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }
    @NonNull
    @Override
    public String toString() {
        return "NewMangaValue{" +
                "nameMangaNew='" + nameMangaNew + '\'' +
                ", chapterNew='" + chapterNew + '\'' +
                ", thumb='" + thumb + '\'' +
                '}';
    }
}
