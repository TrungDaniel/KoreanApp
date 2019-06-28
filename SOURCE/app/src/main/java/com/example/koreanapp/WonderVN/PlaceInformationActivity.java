package com.example.koreanapp.WonderVN;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.koreanapp.Controller.Main.Adapter.PlaceInformationAdapter;
import com.example.koreanapp.Model.PlaceResult;
import com.example.koreanapp.R;

import java.util.ArrayList;

public class PlaceInformationActivity extends AppCompatActivity {
    RecyclerView rvPlaceInformation;
    ArrayList<Object> data = new ArrayList<>();
    PlaceInformationAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_information);
        init();
        conFigRv();
        getData();
    }

    private void conFigRv() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvPlaceInformation.setLayoutManager(layoutManager);
        adapter = new PlaceInformationAdapter(data, this);
        rvPlaceInformation.setAdapter(adapter);


    }

    private void getData() {
        PlaceResult placeResult = (PlaceResult) getIntent().getSerializableExtra("object");
        data.add(placeResult);
        for (int i = 0; i < placeResult.getListMedia().size(); i++) {
            data.add(placeResult.getListMedia().get(i));
        }
        adapter.notifyDataSetChanged();


    }

    private void init() {
        rvPlaceInformation = findViewById(R.id.rv_place_information);
    }
}
