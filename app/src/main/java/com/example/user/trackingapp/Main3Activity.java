package com.example.user.trackingapp;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class Main3Activity extends AppCompatActivity {
    String rTrans, rTime, Weight,Descrip;
    EditText Des;
    Spinner spinner1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        spinner1 = findViewById(R.id.Weight);
        Des = findViewById(R.id.Desc);
        Descrip=Des.getText().toString();
        List<String> list = new ArrayList<>();
        list.add("1kg");
        list.add("10kg");
        list.add("100kg");
        list.add("If More Describe above");
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Weight = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    public void onRadioButtonClickedTransport(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.Truck:
                if (checked)
                rTrans="Truck";
                    break;
            case R.id.Rakshaw:
                if (checked)
                    rTrans="Rakshaw";
                    break;
            case R.id.car:
                if (checked)
                    rTrans="Car";
                    break;
            case R.id.Bike:
                if (checked)
                    rTrans="Bike";
                    break;
            case R.id.Other:
                if (checked)
                    rTrans="Other";
                    break;
        }
    }

    public void onRadioButtonClickedTime(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.Day1:
                if (checked)
                    rTime = "Within 1 day";
                break;
            case R.id.Day10:
                if (checked)
                    rTime = "Within 10 days";
                break;
            case R.id.Month:
                if (checked)
                    rTime = "Within a month";
                break;
            case R.id.Week1:
                if (checked)
                    rTime = "Within 1 week";
                break;
            case R.id.notdefine:
                if (checked)
                    rTime = "Define in desciption";
                break;
        }
    }

    public void nextLocActivity(View view) {
      Intent intent=new Intent(getApplicationContext(),MapsActivity.class);
        Descrip=Des.getText().toString();
      intent.putExtra("Descrip",Descrip);
      intent.putExtra("Transport",rTrans);
      intent.putExtra("Time",rTime);
      intent.putExtra("Weight",Weight);
      startActivity(intent);
    }
}
