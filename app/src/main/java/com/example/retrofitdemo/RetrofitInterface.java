package com.example.retrofitdemo;

import com.example.retrofitdemo.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by ashwin on 3/11/17.
 */

public interface RetrofitInterface {

    @GET("users")
    //Call<User> getUsers(@Query("api_key") String apiKey);
    Call<List<User>> getUsers();

    @GET("users/{id}")
    //Call<User> getUser(@Path("id") int id, @Query("api_key") String apiKey);
    Call<User> getUser(@Path("id") int id);

}
