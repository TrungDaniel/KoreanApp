package com.example.koreanapp.Controller.Main.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.koreanapp.Model.PlaceResult;
import com.example.koreanapp.R;

import java.util.ArrayList;

public class PlaceInformationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public ArrayList<Object> data;
    public Context context;

    public PlaceInformationAdapter(ArrayList<Object> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if (data.get(position) instanceof PlaceResult) {
            return 0;
        }
        return 1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        if (viewType == 0) {
            View view = LayoutInflater.from(context).inflate(R.layout.place_header_item_layout, viewGroup, false);
            return new HeaderViewHolder(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.place_media_item_layout,viewGroup,false);
            return new MediaViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MediaViewHolder extends RecyclerView.ViewHolder {

        public MediaViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder {

        public HeaderViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }


}
