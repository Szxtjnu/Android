package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyData myData = new MyData(getApplicationContext());
        myData.number = 1000;
        myData.save();
        int y = myData.load();
        String TAG = "myLog";
        Log.d(TAG, "onCreate: " + y);
//        SharedPreferences shp = getPreferences(Context.MODE_PRIVATE);
//        SharedPreferences shp = getSharedPreferences("MY_DATA",Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = shp.edit();
//        editor.putInt("NUMBER",600);
//        editor.apply();
//
//        int x = shp.getInt("NUMBER", 0);
//        String TAG = "mylog";
//        Log.d(TAG, "onCreate: " + x);
    }
}