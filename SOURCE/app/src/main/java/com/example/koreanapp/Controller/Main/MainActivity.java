package com.example.koreanapp.Controller.Main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.koreanapp.Model.Promotion;
import com.example.koreanapp.R;
import com.example.koreanapp.WonderVN.ContactActivity;
import com.example.koreanapp.WonderVN.PlaceActivity;
import com.example.koreanapp.WonderVN.PromotionActivity;

public class MainActivity extends AppCompatActivity {
    Button btnPlace,btnContact,btnPromotion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        chuyenManHinh();
    }
    private void chuyenManHinh() {
        btnPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PlaceActivity.class);
                startActivity(intent);
            }
        });
        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ContactActivity.class);
                startActivity(intent);
            }
        });
        btnPromotion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PromotionActivity.class);
                startActivity(intent);
            }
        });


    }

    private void init() {
        btnPlace = findViewById(R.id.btn_place);
        btnContact = findViewById(R.id.btn_contact);
        btnPromotion = findViewById(R.id.btn_promotion);


    }
}
