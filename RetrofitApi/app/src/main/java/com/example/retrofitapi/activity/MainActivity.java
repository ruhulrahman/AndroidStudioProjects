package com.example.retrofitapi.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.retrofitapi.R;
import com.example.retrofitapi.adapter.UserAdapter;
import com.example.retrofitapi.model.User;
import com.example.retrofitapi.retrofit.ApiClient;
import com.example.retrofitapi.retrofit.RetrofitInterface;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private List<User> users;
    private UserAdapter userAdapter;
    private RecyclerView userRV;
    private RetrofitInterface retrofitInterface;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        recycleViewConfig();
        getData();
    }

    private void getData() {
        retrofitInterface = new ApiClient().getInstance().getApi();
        Call<List<User>> call = retrofitInterface.getData();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                users = response.body();
                progressBar.setVisibility(View.GONE);
                userAdapter = new UserAdapter(users);
                userRV.setAdapter(userAdapter);
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(MainActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void recycleViewConfig() {
        userRV.setLayoutManager(new LinearLayoutManager(this));
    }

    private void init() {
        userRV = findViewById(R.id.userRV);
        progressBar = findViewById(R.id.progressBar);
        users = new ArrayList<>();

    }

    public void insertData(View view) {
        Call<ResponseBody> call = retrofitInterface.setData(1, 2, "title", "body");
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Toast.makeText(MainActivity.this, "Successful", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}
