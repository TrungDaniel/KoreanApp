package com.example.koreanapp.Controller.Main.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.koreanapp.Model.CategoryResult;
import com.example.koreanapp.R;
import com.example.koreanapp.WonderVN.BannerInformationActivity;
import com.squareup.picasso.Picasso;

public class HomeImageAdapter extends RecyclerView.Adapter<HomeImageAdapter.ImageViewHolder> {
    public Context context;
    public CategoryResult data;

    public void setContext(Context context) {
        this.context = context;
    }

    public void setData(CategoryResult data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_image_layout, viewGroup, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder imageViewHolder, final int i) {
        Picasso.get().load(data.getListBanner().get(i).getUrlBanner()).into(imageViewHolder.imgHome);
        imageViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.getContext().startActivity(new Intent(v.getContext(), BannerInformationActivity.class)
                        .putExtra("object", (Parcelable) data.getListBanner().get(i).getPlaceHomeImage())
                );

            }
        });

    }

    @Override
    public int getItemCount() {
        return data.getListBanner().size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView imgHome;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            imgHome = itemView.findViewById(R.id.img_home_image);
        }
    }
}
