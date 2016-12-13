package com.example.binc.coreandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.binc.coreandroid.models.Github;
import com.example.binc.coreandroid.network.Error;
import com.example.binc.coreandroid.network.core.ApiClient;
import com.example.binc.coreandroid.network.core.ApiConfig;
import com.example.binc.coreandroid.network.core.Callback;

import java.util.List;

import retrofit2.Call;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Setup Api client
        ApiConfig apiConfig = ApiConfig.builder(getApplicationContext())
                .baseUrl("https://api.github.com/")
                .setAgent(true)
                .setAuth(true)
                .build();
        ApiClient.getInstance().init(apiConfig);


        findViewById(R.id.tvTest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<List<Github>> repos = ApiClient.call().listRepos("octocat");
                repos.enqueue(new Callback<List<Github>>() {
                    @Override
                    public void success(List<Github> githubs) {
                        Log.i("TAG11", githubs.size() + "//");
                    }

                    @Override
                    public void failure(Error myError) {

                    }
                });
            }
        });
    }
}
