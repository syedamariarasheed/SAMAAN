package com.example.user.trackingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void GoAdminpanel(View view) {
        startActivity(new Intent(MainActivity.this,Adminpanel.class));
        finish();
    }

    public void UserPanel(View view) {
        startActivity(new Intent(MainActivity.this,Main3Activity.class));
        finish();
    }
}
