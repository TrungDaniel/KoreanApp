package com.example.koreanapp.WonderVN;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.koreanapp.Model.PlaceHomeImage;
import com.example.koreanapp.R;
import com.squareup.picasso.Picasso;

public class BannerInformationActivity extends AppCompatActivity {
    PlaceHomeImage placeHomeImage;
    ImageView imgPlaceBanner;
    TextView tvPlaceName, tvPlacePhone, tvPlaceLocation, tvPlaceUrl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner_information);
        init();
        getData();
    }

    private void getData() {
        placeHomeImage = (PlaceHomeImage) getIntent().getParcelableExtra("object");
        Picasso.get().load(placeHomeImage.getUrlLogoPlace()).into(imgPlaceBanner);
        tvPlaceName.setText(placeHomeImage.getPlaceName());
        tvPlacePhone.setText(placeHomeImage.getPhone());
        tvPlaceUrl.setText(placeHomeImage.getUrlWeb());
    }

    private void init() {
        imgPlaceBanner = findViewById(R.id.img_information_place);
        tvPlaceName = findViewById(R.id.tv_infomation_place_name);
        tvPlacePhone = findViewById(R.id.tv_infomation_place_phone);
        tvPlaceLocation = findViewById(R.id.tv_infomation_place_address);
        tvPlaceUrl = findViewById(R.id.tv_infomation_place_url);

    }
}
