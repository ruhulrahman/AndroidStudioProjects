package com.example.restapipractice.activity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.example.restapipractice.R;
import com.example.restapipractice.activity.adapter.UserAdapter;
import com.example.restapipractice.activity.model.User;
import com.example.restapipractice.activity.retrofit.ApiClient;
import com.example.restapipractice.activity.retrofit.RetrofitInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private List<User> users;
    private UserAdapter userAdapter;
    private RecyclerView recyclerView;
    private RetrofitInterface retrofitInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        recyclerViewConfig();
        getData();
    }

    private void init() {
        recyclerView = findViewById(R.id.recyclerViewId);
        users = new ArrayList<>();
    }

    private void recyclerViewConfig() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void getData() {
        retrofitInterface = new ApiClient().getInstance().getApi();
        Call<List<User>> call = retrofitInterface.getData("comments?postId=2");
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                users = response.body();
//                Toast.makeText(MainActivity.this, ""+users.size(), Toast.LENGTH_LONG).show();
                userAdapter = new UserAdapter(users);
                recyclerView.setAdapter(userAdapter);
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(MainActivity.this, ""+t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
