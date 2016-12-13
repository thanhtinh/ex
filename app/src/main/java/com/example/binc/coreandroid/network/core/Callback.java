package com.example.binc.coreandroid.network.core;

import android.util.Log;

import com.example.binc.coreandroid.network.Error;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Copyright © 2016 AsianTech inc.
 * Created by Binc on 12/1/16.
 */
public abstract class Callback<T> implements retrofit2.Callback<T> {
    public Callback() {
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        Log.i("TAG11", call.toString());
        success(response.body());
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        failure(new Error(t.getMessage()));
    }

    public abstract void success(T t);

    public abstract void failure(Error myError);

}
