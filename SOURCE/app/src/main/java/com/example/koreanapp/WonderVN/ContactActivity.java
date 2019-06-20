package com.example.koreanapp.WonderVN;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.koreanapp.Controller.Main.Adapter.ContactAdapter;
import com.example.koreanapp.Controller.Main.MainActivity;
import com.example.koreanapp.Model.Contact;
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

public class ContactActivity extends AppCompatActivity {
    RecyclerView rvContact;
    BottomNavigationView bottomNavigationView;
    Toolbar tbContact;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        init();
        toolBar();
        getData();
        chuyenManHinh();
    }

    private void toolBar() {
        setSupportActionBar(tbContact);
        getSupportActionBar().setTitle(null);
    }

    private void chuyenManHinh() {
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_Home:
                        Intent intentHome = new Intent(ContactActivity.this, MainActivity.class);
                        startActivity(intentHome);
                        finish();
                        break;
                    case R.id.nav_place:
                        Intent intentPlace = new Intent(ContactActivity.this, PlaceActivity.class);
                        startActivity(intentPlace);
                        finish();
                        break;
                    case R.id.nav_promotion:
                        Intent intentPromotion = new Intent(ContactActivity.this, PromotionActivity.class);
                        startActivity(intentPromotion);
                        finish();
                        break;

                }
                return false;
            }
        });
    }

    private void getData() {
       getListContactBody getListContactBody = new getListContactBody("","","",0);
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://150.95.115.192/api/")
                .build();
        retrofit.create(WonderVNAPIService.class).getListContact(getListContactBody).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String strJson = response.body().string();
                    Gson gson = new Gson();
                    Contact contact = gson.fromJson(strJson,Contact.class);
                    // ------------- configRvContact
                    LinearLayoutManager linearLayoutManager = new
                            LinearLayoutManager(ContactActivity.this,LinearLayoutManager.VERTICAL,false);
                    rvContact.setLayoutManager(linearLayoutManager);
                    ContactAdapter adapter = new ContactAdapter();
                    adapter.setContext(ContactActivity.this);
                    adapter.setData(contact.getContactResult());
                    rvContact.setAdapter(adapter);
                    rvContact.addItemDecoration(new DividerItemDecoration(ContactActivity.this, DividerItemDecoration.VERTICAL));

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {



            }
        });
    }
    class getListContactBody{
        String userAPI,passAPI,searchKey;
        int contactID;

        public getListContactBody(String userAPI, String passAPI, String searchKey, int contactID) {
            this.userAPI = userAPI;
            this.passAPI = passAPI;
            this.searchKey = searchKey;
            this.contactID = contactID;
        }
    }

    private void init() {
        rvContact = findViewById(R.id.rv_Contact);
        tbContact=findViewById(R.id.tb_contact);
    }
}
