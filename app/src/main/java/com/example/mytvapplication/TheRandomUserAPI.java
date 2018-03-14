package com.example.mytvapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by 3NET01 on 14/03/2018.
 */


    public interface TheRandomUserAPI {
        @GET("api")
        Call<RandomUser> listUsers(@Query("results") int number);
    }

