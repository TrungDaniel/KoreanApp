package com.example.koreanapp.Controller.Main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.koreanapp.Controller.Main.Adapter.PromotionAdapter;
import com.example.koreanapp.Model.Promotion;
import com.example.koreanapp.R;
import com.example.koreanapp.Utils.Util;
import com.google.gson.Gson;

public class PromotionActivity extends AppCompatActivity {
    Promotion data;
    RecyclerView rvPromotion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promotion);
        init();
        docJson();
        setConfigRvPromotion();
    }

    private void setConfigRvPromotion() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvPromotion.setLayoutManager(linearLayoutManager);
        PromotionAdapter adapter = new PromotionAdapter();
        adapter.setContext(this);
        adapter.setData(data.getResult());
        rvPromotion.setAdapter(adapter);
        rvPromotion.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

    }

    private void docJson() {
        String strPromotion = Util.loadJSONPromotionFromAsset(this);
        Gson gson = new Gson();
        data = gson.fromJson(strPromotion, Promotion.class);
    }

    private void init() {
        rvPromotion = findViewById(R.id.rv_promotion);
    }
}
