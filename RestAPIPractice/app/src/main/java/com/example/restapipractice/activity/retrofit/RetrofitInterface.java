package com.example.restapipractice.activity.retrofit;

import com.example.restapipractice.activity.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface RetrofitInterface {
    @GET()
    Call<List<User>> getData(@Url String url);
}
