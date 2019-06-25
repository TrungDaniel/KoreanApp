package com.example.koreanapp.Controller.Main.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.koreanapp.R;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {
    public Context context;

    public void setContext(@NonNull Context context) {
        this.context = context;
    }

    @NonNull
    @Override

    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_item_layout, viewGroup, false);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder homeViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 15 ;
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder {
        ImageView imgHome;
        TextView  tvHomeTitle;
        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
            imgHome = itemView.findViewById(R.id.img_home_item);
            tvHomeTitle = itemView.findViewById(R.id.tv_home_title);
        }
    }
}
