package com.example.koreanapp.Controller.Main.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.koreanapp.Model.PromotionResult;
import com.example.koreanapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PromotionAdapter extends RecyclerView.Adapter<PromotionAdapter.promotionViewHolder> {
    public Context context;
    public List<PromotionResult> data;

    public void setContext(Context context) {
        this.context = context;
    }

    public void setData(List<PromotionResult> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public promotionViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.promotion_item_layout, viewGroup, false);
        return new promotionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull promotionViewHolder promotionViewHolder, int i) {
        PromotionResult promotionResult = data.get(i);
        promotionViewHolder.tvPromotionName.setText(promotionResult.getPlaceDetail().getPlaceName());
        promotionViewHolder.tvPromotionAddress.setText(promotionResult.getPlaceDetail().getAddress());
        Picasso.get().load(promotionResult.getPlaceDetail().getUrlLogoPlace()).into(promotionViewHolder.imgPromotion);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class promotionViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPromotion;
        TextView tvPromotionAddress;
        TextView tvPromotionName;

        public promotionViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPromotionName = itemView.findViewById(R.id.tv_promotion_name);
            tvPromotionAddress = itemView.findViewById(R.id.tv_promotion_address);
            imgPromotion = itemView.findViewById(R.id.img_promotion);
        }
    }
}
