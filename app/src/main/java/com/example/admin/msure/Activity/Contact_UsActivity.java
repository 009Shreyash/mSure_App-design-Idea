package com.example.admin.msure.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.admin.msure.R;

public class Contact_UsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact__us);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
}
