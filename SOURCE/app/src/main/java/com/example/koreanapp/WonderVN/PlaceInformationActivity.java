package com.example.koreanapp.WonderVN;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.koreanapp.Model.PlaceResult;
import com.example.koreanapp.R;
import com.squareup.picasso.Picasso;

public class PlaceInformationActivity extends AppCompatActivity {
    TextView tvInformationName, tvInformationAddress, tvInformationPhone, TvInformationUrl;
    ImageView imgInformation;
    LinearLayout lnCallPhone;
    Toolbar tbPlaceInformation;
    PlaceResult placeResult;
    RecyclerView rvImgPlace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_information);
        init();
        toolBar();
        getData();
        callPhone();

    }

    private void toolBar() {
        setSupportActionBar(tbPlaceInformation);
        getSupportActionBar().setTitle(null);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    private void callPhone() {
        lnCallPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", placeResult.getPhone(), null));
                startActivity(intent);
            }
        });
    }

    private void getData() {
        placeResult = (PlaceResult) getIntent().getParcelableExtra("object");
        tvInformationName.setText(placeResult.getPlaceName());
        tvInformationAddress.setText(placeResult.getAddress());
        tvInformationPhone.setText(placeResult.getPhone());
        TvInformationUrl.setText(placeResult.getUrlWeb());
        Picasso.get().load(placeResult.getUrlLogoPlace()).into(imgInformation);

        // RecyclerView ImagePlace




    }

    private void init() {
        tvInformationName = findViewById(R.id.tv_infomation_place_name);
        tvInformationAddress = findViewById(R.id.tv_infomation_place_address);
        tvInformationPhone = findViewById(R.id.tv_infomation_place_phone);
        imgInformation = findViewById(R.id.img_information_place);
        lnCallPhone = findViewById(R.id.ln_call_phone);
        tbPlaceInformation = findViewById(R.id.tb_place_information);
        TvInformationUrl = findViewById(R.id.tv_infomation_place_url);
    }


}
