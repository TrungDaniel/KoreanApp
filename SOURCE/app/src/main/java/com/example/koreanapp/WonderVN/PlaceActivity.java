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
import android.widget.Toast;

import com.example.koreanapp.Controller.Main.Adapter.PlaceAdapter;
import com.example.koreanapp.Controller.Main.MainActivity;
import com.example.koreanapp.Model.Place;
import com.example.koreanapp.R;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PlaceActivity extends AppCompatActivity {
    RecyclerView rvPlace;
    BottomNavigationView bottomNavigationView;
    Toolbar tbPlace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);
        init();
        toolBar();
        getData();
        chuyenmanhinh();
    }

    private void toolBar() {
        setSupportActionBar(tbPlace);
        getSupportActionBar().setTitle(null);
    }

    private void chuyenmanhinh() {
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_Home:
                        Intent intentHome = new Intent(PlaceActivity.this, MainActivity.class);
                        startActivity(intentHome);
                        finish();
                        break;
                    case R.id.nav_contact:
                        Intent intentContact = new Intent(PlaceActivity.this, ContactActivity.class);
                        startActivity(intentContact);
                        finish();
                        break;
                    case R.id.nav_promotion:
                        Intent intentPromotion = new Intent(PlaceActivity.this, PromotionActivity.class);
                        startActivity(intentPromotion);
                        finish();
                        break;

                }
                return false;
            }
        });
    }

    private void init() {
        rvPlace = findViewById(R.id.rv_Place);
        tbPlace = findViewById(R.id.tb_place);

    }

    private void getData() {
        final ProgressDialog progressDoalog;
        progressDoalog = new ProgressDialog(PlaceActivity.this);
        progressDoalog.setMessage("Loading..........");
        progressDoalog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDoalog.show();
        // khai báo , khởi tạo retrofit
        getListPlaceBody getListPlaceBody = new getListPlaceBody(0, 0, "");
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://150.95.115.192/api/")
                .build();

        retrofit.create(WonderVNAPIService.class).getListPlace(getListPlaceBody).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String strJson = null;
                try {
                    strJson = response.body().string();
                    Gson gson = new Gson();
                    Place place = gson.fromJson(strJson, Place.class);
                    //------------ conFigRvPlace -------
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(PlaceActivity.this, LinearLayoutManager.VERTICAL, false);
                    rvPlace.setLayoutManager(linearLayoutManager);
                    PlaceAdapter adapter = new PlaceAdapter();
                    adapter.setContext(PlaceActivity.this);
                    adapter.setData(place.getPlaceResults());
                    rvPlace.setAdapter(adapter);
                    rvPlace.addItemDecoration(new DividerItemDecoration(PlaceActivity.this, DividerItemDecoration.VERTICAL));
                    progressDoalog.dismiss();


                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(PlaceActivity.this, "Lấy dữ liệu thất bại", Toast.LENGTH_SHORT).show();
                progressDoalog.dismiss();

            }
        });
    }

    class getListPlaceBody {
        int catID, placeID;
        String searchKey;

        public getListPlaceBody(int catID, int placeID, String searchKey) {
            this.catID = catID;
            this.placeID = placeID;
            this.searchKey = searchKey;
        }
    }
}
