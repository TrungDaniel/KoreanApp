package com.example.koreanapp.WonderVN;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.koreanapp.Controller.Main.Adapter.PromotionAdapter;
import com.example.koreanapp.Model.Promotion;
import com.example.koreanapp.R;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PromotionActivity extends AppCompatActivity {
    RecyclerView rvPromotion;
    BottomNavigationView bottomNavigationView;
    Toolbar tbPromotion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promotion);
        init();
        toolBar();
        getData();
    }

    private void toolBar() {
        setSupportActionBar(tbPromotion);
        getSupportActionBar().setTitle(null);
    }


    private void getData() {
        final ProgressDialog progressDoalog;
        progressDoalog = new ProgressDialog(PromotionActivity.this);
        progressDoalog.setMessage("Loading..........");
        progressDoalog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDoalog.show();
        getListPromoionBody getListPromoionBody = new getListPromoionBody(0, 0);
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://150.95.115.192/api/")
                .build();
        retrofit.create(WonderVNAPIService.class).getListPromotion(getListPromoionBody).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String strJson = response.body().string();
                    Gson gson = new Gson();
                    Promotion promotion = gson.fromJson(strJson, Promotion.class);
                    //-----------conFigRvPromotion
                    LinearLayoutManager linearLayoutManager = new
                            LinearLayoutManager(PromotionActivity.this, LinearLayoutManager.VERTICAL, false);
                    rvPromotion.setLayoutManager(linearLayoutManager);
                    PromotionAdapter adapter = new PromotionAdapter();
                    adapter.setContext(PromotionActivity.this);
                    adapter.setData(promotion.getResult());
                    rvPromotion.setAdapter(adapter);
                    rvPromotion.addItemDecoration(new DividerItemDecoration(PromotionActivity.this, DividerItemDecoration.VERTICAL));
                    progressDoalog.dismiss();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                progressDoalog.dismiss();

            }
        });

    }

    private void init() {
        rvPromotion = findViewById(R.id.rv_promotion);
        tbPromotion = findViewById(R.id.tb_promotion);
    }

    class getListPromoionBody {
        Integer page, promotionID;

        public getListPromoionBody(Integer page, Integer promotionID) {
            this.page = page;
            this.promotionID = promotionID;
        }
    }
}
