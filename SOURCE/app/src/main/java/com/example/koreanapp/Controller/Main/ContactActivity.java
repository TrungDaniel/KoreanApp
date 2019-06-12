package com.example.koreanapp.Controller.Main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.koreanapp.Controller.Main.Adapter.ContactAdapter;
import com.example.koreanapp.Model.Contact;
import com.example.koreanapp.Model.ContactResult;
import com.example.koreanapp.Model.Place;
import com.example.koreanapp.R;
import com.example.koreanapp.Utils.Util;
import com.google.gson.Gson;

public class ContactActivity extends AppCompatActivity {
    RecyclerView rvContact;
    Contact placedata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        init();
        docJson();
        configRvContact();

    }

    private void configRvContact() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rvContact.setLayoutManager(linearLayoutManager);
        ContactAdapter adapter = new ContactAdapter();
        adapter.setContext(this);
        adapter.setData(placedata.getContactResult());
        rvContact.setAdapter(adapter);

    }


    private void docJson() {
        String strHomeData = Util.loadJSONContactFromAsset(this);
        Gson gson = new Gson();
        placedata = gson.fromJson(strHomeData, Contact.class);

    }

    private void init() {
        rvContact = findViewById(R.id.rv_contact);
    }
}
