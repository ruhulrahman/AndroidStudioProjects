package com.example.retrofitapi.retrofit;

import com.example.retrofitapi.model.User;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RetrofitInterface {
    @GET("posts")
    Call<List<User>> getData();


    @FormUrlEncoded
    @POST("posts")
    Call<ResponseBody> setData(
            @Field("userId") int userId,
            @Field("id") int id,
            @Field("title") String title,
            @Field("body") String body
    );
}
