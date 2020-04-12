package com.example.projectekam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.projectekam.Data.IndianCities;
import com.example.projectekam.Model.AsyncIndianCities;
import com.example.projectekam.Model.IndianCitiesApi;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<IndianCities> indianCitiesList;
    private int currentIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        indianCitiesList = new IndianCitiesApi().getIndianCities(new AsyncIndianCities() {
            @Override
            public void processFinished(ArrayList<IndianCities> indianCitiesArrayList) {
                Log.d("MAIN", "processFinished: "+indianCitiesArrayList.get(0).getDistrict());
            }
        });

    }
}
