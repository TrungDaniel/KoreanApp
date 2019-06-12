package com.example.koreanapp.Controller.Main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.koreanapp.Controller.Main.Adapter.PlaceAdapter;
import com.example.koreanapp.Model.Place;
import com.example.koreanapp.R;
import com.example.koreanapp.Utils.Util;
import com.google.gson.Gson;

public class PlaceActivity extends AppCompatActivity {
    RecyclerView rvPlace;
    Place placedata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);
        init();
        docJson();
        configRvPlace();
    }

    private void docJson() {
        String strHomeData = Util.loadJSONPlaceFromAsset(this);
        Gson gson = new Gson();
        placedata = gson.fromJson(strHomeData, Place.class);
    }

    private void configRvPlace() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvPlace.setLayoutManager(linearLayoutManager);
        PlaceAdapter adapter = new PlaceAdapter();
        adapter.setContext(this);
        adapter.setData(placedata.getPlaceResults());
        rvPlace.setAdapter(adapter);
        rvPlace.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    private void init() {
        rvPlace = findViewById(R.id.rv_place);
    }
}
