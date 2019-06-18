package com.example.koreanapp.WonderVN;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.koreanapp.Model.Place;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_information);
        init();
        getData();
    }

    private void init() {
        tvInformationName=findViewById(R.id.tv_infomation_place_name);
        tvInformationAddress=findViewById(R.id.tv_infomation_place_address);
        tvInformationPhone=findViewById(R.id.tv_infomation_place_phone);
        imgInformation=findViewById(R.id.img_information_place);
    }

    private void getData() {
        final int informationId=getIntent().getIntExtra("informationID",0);
        getInformationPlace getInformationPlace = new getInformationPlace(0,0,"");
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://150.95.115.192/api/")
                .build();
        retrofit.create(WonderVNAPIService.class).getListPlace(getInformationPlace).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String strJson = null;
                try {
                    strJson = response.body().string();
                    Gson gson = new Gson();
                    Place place = gson.fromJson(strJson,Place.class);
                    tvInformationName.setText(place.getPlaceResults().get(informationId).getPlaceName());
                    tvInformationAddress.setText(place.getPlaceResults().get(informationId).getAddress());
                    tvInformationPhone.setText(place.getPlaceResults().get(informationId).getPhone());
                    Picasso.get().load(place.getPlaceResults().get(informationId).getUrlLogoPlace()).into(imgInformation);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });


    }
    class getInformationPlace{
        int catID, placeID;
        String searchKey;

        public getInformationPlace(int catID, int placeID, String searchKey) {
            this.catID = catID;
            this.placeID = placeID;
            this.searchKey = searchKey;
        }

    }
}
