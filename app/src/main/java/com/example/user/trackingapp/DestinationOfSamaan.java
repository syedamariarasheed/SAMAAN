package com.example.user.trackingapp;


import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Filter;
import android.widget.SearchView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.android.gms.common.api.Status;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.TypeFilter;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;


import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;

import static java.lang.String.format;

public class DestinationOfSamaan extends AppCompatActivity implements OnMapReadyCallback {

    SearchView searchView;
    SupportMapFragment mapFragment;
    String url="https://test350999.000webhostapp.com/inserinfo.php";
    GoogleMap map;
    PlacesClient placesClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination_of_samaan);
        mapFragment=(SupportMapFragment)getSupportFragmentManager()
                .findFragmentById(R.id.map3);

          Destination();
//    searchView=findViewById(R.id.searchView);

//    searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//        @Override
//        public boolean onQueryTextSubmit(String s) {
//         String location=searchView.getQuery().toString();
//            List<Address> addressList=null;
//            if (location != null || !location.equals("")){
//                Geocoder geocoder=new Geocoder(DestinationOfSamaan.this);
//                try {
//                    addressList=geocoder.getFromLocationName(location,1);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                Address address =addressList.get(0);
//                LatLng latLng=new LatLng(address.getLatitude(),address.getLongitude());
//                map.addMarker(new MarkerOptions().position(latLng).title(location));
//                map.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,10));
//            }
//            return false;
//        }
//
//        @Override
//        public boolean onQueryTextChange(String s) {
//            return false;
//        }
//
//    });
    mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        map=googleMap;

    }



    public void Destination(){
     final    String key="AIzaSyC27aVjYBl6kdhYvRhsK2-BzwTmnlYQ4p0";
        if(!Places.isInitialized()){
            Places.initialize(getApplicationContext(),key);
        }
        placesClient=Places.createClient(this);
        final AutocompleteSupportFragment autocompleteSupportFragment=(AutocompleteSupportFragment) getSupportFragmentManager().findFragmentById(R.id.autocomplete_fragment);
        autocompleteSupportFragment.setCountry("PK");
        autocompleteSupportFragment.setTypeFilter(TypeFilter.ADDRESS);
        autocompleteSupportFragment.setPlaceFields(Arrays.asList(Place.Field.ID, Place.Field.NAME));
        autocompleteSupportFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                final  LatLng latLng=place.getLatLng();
                map.addMarker(new MarkerOptions().position(latLng).title(""));
                map.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,10));
            }

            @Override
            public void onError(Status status) {

            }
        });

    }
}
