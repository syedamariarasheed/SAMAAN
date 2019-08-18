package com.example.user.trackingapp;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Adminpanel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminpanel);
    }

    public void GetRequest(View view) {
        startActivity(new Intent(Adminpanel.this,ClientRequest.class));
    }



}
