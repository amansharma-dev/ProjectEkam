package com.example.projectekam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.projectekam.Data.IndianCities;
import com.example.projectekam.Model.AsyncIndianCities;
import com.example.projectekam.Model.IndianCitiesApi;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private List<IndianCities> indianCitiesList;
    private int currentIndex = 0;
    private TextView city;
    private TextView state;
    private TextView district;

    private CardView cardView;
    private ImageButton nextIB;
    private ImageButton backIB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        city=findViewById(R.id.cityName_textView);
        state=findViewById(R.id.stateName_textView);
        district=findViewById(R.id.districtName_textView);
        cardView=findViewById(R.id.cV_cardView);
        nextIB=findViewById(R.id.next_imageButton);
        backIB=findViewById(R.id.back_imageButton);
        nextIB.setOnClickListener(this);
        backIB.setOnClickListener(this);
        cardView.setCardBackgroundColor(getResources().getColor(R.color.colorCardColor));
        indianCitiesList = new IndianCitiesApi().getIndianCities(new AsyncIndianCities() {
            @Override
            public void processFinished(ArrayList<IndianCities> indianCitiesArrayList) {

                city.setText(indianCitiesArrayList.get(currentIndex).getCity());
                state.setText(indianCitiesArrayList.get(currentIndex).getState());
                district.setText(indianCitiesArrayList.get(currentIndex).getDistrict());
                Log.d("MAIN", "processFinished: "+indianCitiesArrayList.get(0).getDistrict());
            }
        });


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back_imageButton:
                if (currentIndex>0){
                    currentIndex = (currentIndex - 1) % indianCitiesList.size();
                    updateIndianCities();
                }
                break;
            case R.id.next_imageButton:
                currentIndex = (currentIndex + 1) % indianCitiesList.size();
                updateIndianCities();
                break;
        }
    }

    public void updateIndianCities(){
        String updateCity = indianCitiesList.get(currentIndex).getCity();
        String updateSate = indianCitiesList.get(currentIndex).getState();
        String updateDistrict = indianCitiesList.get(currentIndex).getDistrict();

        city.setText(updateCity);
        state.setText(updateSate);
        district.setText(updateDistrict);
    }

}
