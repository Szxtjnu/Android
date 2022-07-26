package com.example.viewmodelshp;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.SavedStateHandle;

public class MyViewModel extends AndroidViewModel {

    SavedStateHandle handle;
    String key = getApplication().getResources().getString(R.string.data_key);
    String shpName = getApplication().getResources().getString(R.string.shp_mame);

    public MyViewModel(@NonNull Application application, SavedStateHandle handle) {
        super(application);
        this.handle = handle;
        if (!handle.contains(key)) {
            load();
        }
    }

    LiveData<Integer> getNumber() {
        return handle.getLiveData(key);
    }

    void load() {
        SharedPreferences shp = getApplication().getSharedPreferences(shpName, Context.MODE_PRIVATE);
        int x = shp.getInt(key, 0);
        handle.set(key, x);
    }

    void save() {
        SharedPreferences shp = getApplication().getSharedPreferences(shpName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shp.edit();
        editor.putInt(key, getNumber().getValue());
        editor.apply();
    }

    void add(int x) {
       handle.set(key, getNumber().getValue() + x);
    }

}
