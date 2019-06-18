package com.example.koreanapp.Controller.Main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Button;

import com.example.koreanapp.R;
import com.example.koreanapp.WonderVN.ContactActivity;
import com.example.koreanapp.WonderVN.PlaceActivity;
import com.example.koreanapp.WonderVN.PromotionActivity;

public class MainActivity extends AppCompatActivity {
    Button btnPlace, btnContact, btnPromotion;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        chuyenManHinh();

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
                        break;
                    case R.id.nav_contact:
                        Intent intentContact = new Intent(MainActivity.this, ContactActivity.class);
                        startActivity(intentContact);
                        break;
                    case R.id.nav_promotion:
                        Intent intentPromotion = new Intent(MainActivity.this, PromotionActivity.class);
                        startActivity(intentPromotion);
                        break;

                }
                return false;
            }
        });


    }


    private void init() {


    }
}
