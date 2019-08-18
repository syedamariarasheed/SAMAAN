package com.example.user.trackingapp;


import android.os.Bundle;
import android.widget.Spinner;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.model.LatLng;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ClientRequest extends AppCompatActivity {
RecyclerView recyclerView;
    String Json_Url = "https://test350999.000webhostapp.com/RecReq.php";
    String item,JSON_STRINGPro;
    LatLng latLng;
    Adapter adapter;
    JSONObject json_object;
    JSONArray jsonArray;
    ArrayList<RequestDetails> Listt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_request);
        Listt=new ArrayList<>();
recyclerView=(RecyclerView)findViewById(R.id.RecyclerView);


    }

    @Override
    protected void onStart() {
        super.onStart();
        getList();
    }

    private void getList() {

        StringRequest stringRequest=new StringRequest(Request.Method.GET, Json_Url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Listt.clear();

                try {
                    json_object=new JSONObject(response);
                    jsonArray =json_object.getJSONArray("server_response");
                    int count=0;

                    while (count<jsonArray.length()){
                        JSONObject jo=jsonArray.getJSONObject(count);

                        RequestDetails requestDetails=new RequestDetails();
                        requestDetails.setDescription_(jo.getString("Desc_"));
                        requestDetails.setLocation_(jo.getString("Loc"));
                        requestDetails.setTime_(jo.getString("Time"));
                        requestDetails.setTransport_(jo.getString("Transport"));
                        requestDetails.setWeight_(jo.getString("Weight"));
                        Listt.add(requestDetails);
                        count++;

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                adapter=new Adapter(ClientRequest.this,Listt);
                recyclerView.setLayoutManager(new LinearLayoutManager(ClientRequest.this));
                recyclerView.setAdapter(adapter);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        );

        Volley.newRequestQueue(this).add(stringRequest);
    }
}


