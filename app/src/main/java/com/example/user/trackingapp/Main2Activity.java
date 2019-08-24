package com.example.user.trackingapp;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.HashMap;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity implements OnMapReadyCallback {


    TextView textView,textView2,textView3,textView4;
    GoogleMap mgoogleMap;
    MapView mapView;
    View view;
    String des,weightt,timee,transportt;
  String latLngget;
  String[] latLng;
    String latitude1,longitude1;
  double latitude,longitude;
    LatLng mylocation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView=findViewById(R.id.mDescription);
        textView2=findViewById(R.id.mTime);
        textView3=findViewById(R.id.mTransport);
        textView4=findViewById(R.id.mWeight);

        Intent intent=getIntent();
        //get Intent
        des=intent.getExtras().getString("Desc_");
        weightt=intent.getExtras().getString("Weight_");
        timee=intent.getExtras().getString("Time_");
        transportt=intent.getExtras().getString("Transport_");
        latLngget=  intent.getExtras().getString("Location_");

        latLng = latLngget.split(",");
        longitude1=latLng[0].replaceAll("[^\\d.]", "");
        latitude1=latLng[1].replaceAll("[^\\d.]", "");
         latitude = Double.parseDouble(longitude1);
         longitude = Double.parseDouble(latitude1);
         mylocation = new LatLng(latitude, longitude);
       mapView=(MapView)findViewById(R.id.map2);
       if(mapView!=null){
           mapView.onCreate(null);
           mapView.onResume();
           mapView.getMapAsync(this);
       }
    }


    @Override
    protected void onStart() {
        super.onStart();
        textView.setText(des);
        textView2.setText(timee);
        textView3.setText(transportt);
        textView4.setText(weightt);
    }

    public void onMapReady(GoogleMap googleMap) {
            MapsInitializer.initialize(getApplicationContext());
            mgoogleMap=googleMap;
            googleMap.addMarker(new MarkerOptions().position(mylocation).title("Here's Your friend"));
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mylocation,15));
    }
}
