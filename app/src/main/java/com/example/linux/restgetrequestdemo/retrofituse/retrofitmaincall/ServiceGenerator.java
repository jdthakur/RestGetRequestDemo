package com.example.linux.restgetrequestdemo.retrofituse.retrofitmaincall;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by linux on 28/8/17.
 */

public class ServiceGenerator {


    private static Retrofit builder;

    public static Retrofit getDataFromAPI(String API_BASE_URL)
    {

        builder = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return builder;


    }

}


