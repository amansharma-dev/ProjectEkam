package com.example.projectekam.Util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class Pref {
    private SharedPreferences sharedPreferences;

    public Pref(Activity activity) {
        this.sharedPreferences = activity.getPreferences(Context.MODE_PRIVATE);
    }

    public void setState(int index){
        sharedPreferences.edit().putInt("currentIndex_value",index).apply();
    }

    public int getState(){
        return sharedPreferences.getInt("currentIndex_value",0);
    }
}
