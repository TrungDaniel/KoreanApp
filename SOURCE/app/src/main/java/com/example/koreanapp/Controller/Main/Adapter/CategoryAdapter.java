package com.example.koreanapp.Controller.Main.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.koreanapp.Model.CategoryResult;
import com.example.koreanapp.Model.ListCate;
import com.example.koreanapp.R;
import com.squareup.picasso.Picasso;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.HomeViewHolder> {
    public Context context;
    public CategoryResult data;

    public void setData(CategoryResult data) {
        this.data = data;
    }

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
        final ListCate listCate = data.getListCate().get(i);
        Picasso.get().load(listCate.getUrlCategory()).into(homeViewHolder.imgHome);
        homeViewHolder.tvHomeTitle.setText(listCate.getName());
        homeViewHolder.imgHome.setColorFilter(Color.WHITE);
        homeViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "" + listCate.getName(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return data.getListCate().size();
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder {
        ImageView imgHome;
        TextView tvHomeTitle;

        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
            imgHome = itemView.findViewById(R.id.img_home_item);
            tvHomeTitle = itemView.findViewById(R.id.tv_home_title);
        }
    }
}
