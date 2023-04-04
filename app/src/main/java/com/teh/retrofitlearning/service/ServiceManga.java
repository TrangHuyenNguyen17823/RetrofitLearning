package com.teh.retrofitlearning.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.teh.retrofitlearning.models.HotMangaModel;
import com.teh.retrofitlearning.models.HotUpdateModel;
import com.teh.retrofitlearning.models.HotUpdateValue;
import com.teh.retrofitlearning.models.LatestUpdateModel;
import com.teh.retrofitlearning.models.NewManga;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ServiceManga {
    @GET("home")
    Call<HotUpdateModel> getAllHotUpdate();
    @GET("home")
    Call<LatestUpdateModel> getAllLatestUpdate();
    @GET("home")
    Call<HotMangaModel> getAllHotManga();
    @GET("home")
    Call<NewManga> getAllNewManga();

    Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyy").create();
    ServiceManga serviceManga = new Retrofit.Builder()
            .baseUrl("http://14.225.7.179:42591/Hot-Book/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ServiceManga.class);


    @GET()
    Call<List<HotUpdateValue>> getListHotUpdateValue();
}
