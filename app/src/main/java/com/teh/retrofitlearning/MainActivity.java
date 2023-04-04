package com.teh.retrofitlearning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.teh.retrofitlearning.adapters.HotUpdateAdapter;
import com.teh.retrofitlearning.databinding.ActivityMainBinding;
import com.teh.retrofitlearning.models.HotMangaModel;
import com.teh.retrofitlearning.models.HotMangaValue;
import com.teh.retrofitlearning.models.HotUpdateModel;
import com.teh.retrofitlearning.models.HotUpdateValue;
import com.teh.retrofitlearning.models.LatestUpdateModel;
import com.teh.retrofitlearning.models.LatestUpdateValue;
import com.teh.retrofitlearning.models.NewManga;
import com.teh.retrofitlearning.models.NewMangaValue;
import com.teh.retrofitlearning.service.ServiceManga;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private RecyclerView HotUpdateRecyclerView;
    private List<HotUpdateValue> listHotUpdateValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getJson();

        HotUpdateRecyclerView = findViewById(R.id.HotUpdateRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        HotUpdateRecyclerView.setLayoutManager(linearLayoutManager);

        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL);
        HotUpdateRecyclerView.addItemDecoration( itemDecoration);
        listHotUpdateValue = new ArrayList<>();
        callApiGetHotManga();
    }

    private void callApiGetHotManga()
    {
        try {
            ServiceManga.serviceManga.getListHotUpdateValue().enqueue(new Callback<List<HotUpdateValue>>() {
                @Override
                public void onResponse(Call<List<HotUpdateValue>> call, Response<List<HotUpdateValue>> response) {
                    listHotUpdateValue = (List<HotUpdateValue>) response.body();
                    HotUpdateAdapter hotUpdateAdapter = new HotUpdateAdapter(listHotUpdateValue);
                    HotUpdateRecyclerView.setAdapter(hotUpdateAdapter);
                }

                @Override
                public void onFailure(Call<List<HotUpdateValue>> call, Throwable t) {

                }
            });
        }
        catch (Exception e ){ Log.e("TAG", "callApiGetHotManga: "+e);};


    }
    private void getJson() {
        String baseUrl = "http://14.225.7.179:42591/Hot-Book";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ServiceManga serviceManga = retrofit.create(ServiceManga.class);
        Call<HotUpdateModel> hotUpdateCall = serviceManga.getAllHotUpdate();
        hotUpdateCall.enqueue(new Callback<HotUpdateModel>() {
            @Override
            public void onResponse(Call<HotUpdateModel> call, Response<HotUpdateModel> response) {
                Log.d("hotUpdate", String.valueOf(response.raw()));
                HotUpdateModel hotUpdateModel = response.body();
                assert hotUpdateModel != null;
                List<HotUpdateValue> hotUpdateValueList = hotUpdateModel.getHotUpdate();
                HotUpdateAdapter hotUpdateAdapter = new HotUpdateAdapter((List<HotUpdateValue>) hotUpdateValueList);
                binding.HotUpdateRecyclerView.setAdapter(hotUpdateAdapter);
            }

            @Override
            public void onFailure(Call<HotUpdateModel> call, Throwable t) {

            }
        });
        Call<LatestUpdateModel> latestUpdateCall = serviceManga.getAllLatestUpdate();
        latestUpdateCall.enqueue(new Callback<LatestUpdateModel>() {
            @Override
            public void onResponse(Call<LatestUpdateModel> call, Response<LatestUpdateModel> response) {
                Log.d("latestUpdate", String.valueOf(response.raw()));
                LatestUpdateModel latestUpdateModel = response.body();
                assert latestUpdateModel != null;
                List<LatestUpdateValue> latestUpdateValueList = latestUpdateModel.getLatestUpdate();
                for (LatestUpdateValue latestUpdateValue : latestUpdateValueList) {
                    Log.d("latestUpdate", latestUpdateValue.toString());
                }
            }

            @Override
            public void onFailure(Call<LatestUpdateModel> call, Throwable t) {

            }
        });
        Call<HotMangaModel> hotMangaModel = serviceManga.getAllHotManga();
        hotMangaModel.enqueue(new Callback<HotMangaModel>() {
            @Override
            public void onResponse(Call<HotMangaModel> call, Response<HotMangaModel> response) {
                Log.d("hotManga", response.raw().toString());
                HotMangaModel hotMangaModel = response.body();
                List<HotMangaValue> hotMangaValues = hotMangaModel.getHotManga();
                for (HotMangaValue hotMangaValue : hotMangaValues) {
                    Log.d("hotManga", hotMangaValue.toString());
                }
            }

            @Override
            public void onFailure(Call<HotMangaModel> call, Throwable t) {

            }
        });
        Call<NewManga> newMangaCall = serviceManga.getAllNewManga();
        newMangaCall.enqueue(new Callback<NewManga>() {
            @Override
            public void onResponse(Call<NewManga> call, Response<NewManga> response) {
                Log.d("newManga", response.raw().toString());
                NewManga newManga = response.body();
                List<NewMangaValue> newMangaValues = newManga.getNewManga();
                for (NewMangaValue newMangaValue : newMangaValues) {
                    Log.d("newManga", newMangaValue.toString());
                }
            }

            @Override
            public void onFailure(Call<NewManga> call, Throwable t) {

            }
        });
    }
}