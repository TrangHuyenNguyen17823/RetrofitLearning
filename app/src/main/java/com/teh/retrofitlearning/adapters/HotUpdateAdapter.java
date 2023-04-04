package com.teh.retrofitlearning.adapters;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.teh.retrofitlearning.databinding.HotUpdateContainerBinding;
import com.teh.retrofitlearning.models.HotUpdateModel;
import com.teh.retrofitlearning.models.HotUpdateValue;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class HotUpdateAdapter extends RecyclerView.Adapter<HotUpdateAdapter.HotUpdateViewHolder>{
    private final List<HotUpdateValue> hotUpdateValues;

    public HotUpdateAdapter(List<HotUpdateValue> hotUpdateValues) {
        this.hotUpdateValues = hotUpdateValues;
    }

    @NonNull
    @Override
    public HotUpdateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        HotUpdateContainerBinding hotUpdateContainerBinding = HotUpdateContainerBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );
        return new HotUpdateViewHolder(hotUpdateContainerBinding);
    }

    @Override
    public void onBindViewHolder(HotUpdateViewHolder holder, int position) {
        holder.setData(hotUpdateValues.get(position));
    }

    @Override
    public int getItemCount() {
        return hotUpdateValues.size();
    }

    public class HotUpdateViewHolder extends RecyclerView.ViewHolder{
        private final HotUpdateContainerBinding binding;
        public HotUpdateViewHolder(HotUpdateContainerBinding hotUpdateContainerBinding) {
            super(hotUpdateContainerBinding.getRoot());
            binding = hotUpdateContainerBinding;

        }
        public void setData(HotUpdateValue hotUpdateValue) {
            Log.d("setData", "setData: " + hotUpdateValue.getImage());
            Picasso.get().load(hotUpdateValue.getImage()).into(binding.HotUpdateImageView);
            binding.HotUpdateTextView.setText(hotUpdateValue.getName());
        }
    }
}
