package com.applex.movierecommendation;

import android.app.Activity;
import android.content.SharedPreferences;

public class IntroPref {

    SharedPreferences sharedPreferences;

    public IntroPref(Activity activity){
        sharedPreferences = activity.getPreferences(activity.MODE_PRIVATE);
    }

    public void setSearch(String search){
        sharedPreferences.edit().putString("search", search).commit();
    }

    public String getSearch(){
        return sharedPreferences.getString("search", "Batman");
    }
}
