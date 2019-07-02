package com.example.koreanapp;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
    }

    private void init() {
        // khởi tạo fragment category khi khởi động
        CategoryFragment categoryFragment = new CategoryFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, categoryFragment);
        fragmentTransaction.commit();

        // khởi tạo các fragment khi click vào mỗi item
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_category: {
                        CategoryFragment categoryFragment = new CategoryFragment();
                        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.container, categoryFragment);
                        fragmentTransaction.commit();
                        break;
                    }
                    case R.id.nav_place: {
                        PlaceFragment placeFragment = new PlaceFragment();
                        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.container, placeFragment);
                        fragmentTransaction.commit();
                        break;
                    }
                    case R.id.nav_contact: {
                        Toast.makeText(HomeActivity.this, "contact", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.nav_promotion: {
                        Toast.makeText(HomeActivity.this, "Category", Toast.LENGTH_SHORT).show();
                        break;
                    }
                }
                return true;
            }
        });
    }
}
