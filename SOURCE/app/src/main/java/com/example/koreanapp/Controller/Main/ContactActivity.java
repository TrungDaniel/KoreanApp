package com.example.koreanapp.Controller.Main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.koreanapp.Controller.Main.Adapter.ContactAdapter;
import com.example.koreanapp.Model.Contact;
import com.example.koreanapp.R;
import com.example.koreanapp.Utils.Util;
import com.google.gson.Gson;

public class ContactActivity extends AppCompatActivity {
    RecyclerView rvContact;
    Contact placeData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        init();
        docJson();
        configRvContact();

    }

    private void configRvContact() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvContact.setLayoutManager(linearLayoutManager);
        ContactAdapter adapter = new ContactAdapter();
        adapter.setContext(this);
        adapter.setData(placeData.getContactResult());
        rvContact.setAdapter(adapter);
        rvContact.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

    }


    private void docJson() {
        String strContactData = Util.loadJSONContactFromAsset(this);
        Gson gson = new Gson();
        placeData = gson.fromJson(strContactData, Contact.class);

    }

    private void init() {
        rvContact = findViewById(R.id.rv_contact);
    }
}
