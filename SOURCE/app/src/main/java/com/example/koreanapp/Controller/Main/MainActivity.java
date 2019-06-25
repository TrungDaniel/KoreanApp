package com.example.koreanapp.Controller.Main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.koreanapp.Controller.Main.Adapter.HomeAdapter;
import com.example.koreanapp.Controller.Main.Adapter.HomeImageAdapter;
import com.example.koreanapp.Model.Category;
import com.example.koreanapp.R;
import com.example.koreanapp.WonderVN.ContactActivity;
import com.example.koreanapp.WonderVN.PlaceActivity;
import com.example.koreanapp.WonderVN.PromotionActivity;
import com.example.koreanapp.WonderVN.WonderVNAPIService;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    Toolbar tbMain;
    RecyclerView rvHome, rvHomeImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        toolBar();
        chuyenManHinh();
        getData();

    }

    private void getData() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://150.95.115.192/api/")
                .build();
        retrofit.create(WonderVNAPIService.class).getListCategory().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String strJson = null;
                try {
                    strJson = response.body().string();
                    Gson gson = new Gson();
                    Category category = gson.fromJson(strJson, Category.class);
                    rvHome.setLayoutManager(new GridLayoutManager(MainActivity.this, 4));
                    HomeAdapter adapter = new HomeAdapter();
                    adapter.setContext(MainActivity.this);
                    adapter.setData(category.getCategoryResult());
                    rvHome.setAdapter(adapter);
                    // Recycler View Image
                    LinearLayoutManager linearLayoutManager =
                            new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
                    rvHomeImage.setLayoutManager(linearLayoutManager);
                    HomeImageAdapter homeImageAdapter = new HomeImageAdapter();
                    homeImageAdapter.setContext(MainActivity.this);
                    homeImageAdapter.setData(category.getCategoryResult());
                    rvHomeImage.setAdapter(homeImageAdapter);
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(MainActivity.this, "lấy dữ liệu thất bại", Toast.LENGTH_SHORT).show();

            }
        });


    }

    private void toolBar() {
        setSupportActionBar(tbMain);
        getSupportActionBar().setTitle(null);
    }

    private void chuyenManHinh() {
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_place:
                        Intent intentPlace = new Intent(MainActivity.this, PlaceActivity.class);
                        startActivity(intentPlace);
                        finish();
                        break;
                    case R.id.nav_contact:
                        Intent intentContact = new Intent(MainActivity.this, ContactActivity.class);
                        startActivity(intentContact);
                        finish();
                        break;
                    case R.id.nav_promotion:
                        Intent intentPromotion = new Intent(MainActivity.this, PromotionActivity.class);
                        startActivity(intentPromotion);
                        finish();
                        break;

                }
                return false;
            }
        });


    }

    private void init() {
        tbMain = findViewById(R.id.tb_main);
        rvHome = findViewById(R.id.rv_home);
        rvHomeImage = findViewById(R.id.rv_home_image);
    }

}
