package com.example.koreanapp.WonderVN;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.koreanapp.Model.Place;
import com.example.koreanapp.Model.PlaceResult;
import com.example.koreanapp.R;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PlaceInformationActivity extends AppCompatActivity {
    TextView tvInformationName,tvInformationAddress,tvInformationPhone;
    ImageView imgInformation;
    Button btnCall;
    Toolbar tbPlaceInformation;
    PlaceResult placeResult;
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
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", placeResult.getPhone(), null));
                startActivity(intent);
            }
        });
    }

    private void getData() {
        placeResult = (PlaceResult)getIntent().getParcelableExtra("object");
        tvInformationName.setText(placeResult.getPlaceName());
        tvInformationAddress.setText(placeResult.getAddress());
        tvInformationPhone.setText(placeResult.getPhone());
        Picasso.get().load(placeResult.getUrlLogoPlace()).into(imgInformation);


    }

    private void init() {
        tvInformationName=findViewById(R.id.tv_infomation_place_name);
        tvInformationAddress=findViewById(R.id.tv_infomation_place_address);
        tvInformationPhone=findViewById(R.id.tv_infomation_place_phone);
        imgInformation=findViewById(R.id.img_information_place);
        btnCall = findViewById(R.id.btn_call);
        tbPlaceInformation=findViewById(R.id.tb_place_information);
    }


}
