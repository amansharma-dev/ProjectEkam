package com.example.projectekam.Model;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.projectekam.Controller.AppController;
import com.example.projectekam.Data.IndianCities;

import org.json.JSONArray;
import org.json.JSONException;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class IndianCitiesApi {
    private String url = "https://indian-cities-api-nocbegfhqg.now.sh/cities";
    private ArrayList<IndianCities> indianCitiesArrayList = new ArrayList<>();
    private RequestQueue requestQueue;

    public List<IndianCities> getIndianCities(final AsyncIndianCities callback){

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("RESPONSE", "onResponse: "+response);
                        for(int i=0; i<response.length();i++){
                            IndianCities indianCities = new IndianCities();

                            try {
                                indianCities.setCity(response.getJSONObject(i).getString("City"));
                                indianCities.setState(response.getJSONObject(i).getString("State"));
                                indianCities.setDistrict(response.getJSONObject(i).getString("District"));

                                indianCitiesArrayList.add(indianCities);

                                Log.d("JSONOBJECT", "onResponse: "+response.getJSONObject(i).getString("City")+", "+response.getJSONObject(i).getString("State")+","+response.getJSONObject(i).getString("District"));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        if(null != callback){
                            callback.processFinished(indianCitiesArrayList);
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("ERROR", "onErrorResponse: "+error.getMessage());
            }
        });

        AppController.getInstance().addToRequestQueue(jsonArrayRequest);
        return indianCitiesArrayList;
    }
}
