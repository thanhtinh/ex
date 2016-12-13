package com.example.binc.coreandroid.network;

import com.example.binc.coreandroid.models.Github;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Copyright © 2016 AsianTech inc.
 * Created by Binc on 12/1/16.
 */

public interface Api {
    @GET("users/{user}/repos")
    Call<List<Github>> listRepos(@Path("user") String user);
}
