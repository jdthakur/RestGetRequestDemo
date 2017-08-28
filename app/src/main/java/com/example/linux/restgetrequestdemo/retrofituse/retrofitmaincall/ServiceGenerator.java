package com.example.linux.restgetrequestdemo.retrofituse.retrofitmaincall;

import java.util.HashMap;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by linux on 28/8/17.
 */

public class ServiceGenerator {


    private static Retrofit builder;

    public static Retrofit getDataFromAPI(String API_BASE_URL) {

        builder = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return builder;


    }

    public static HashMap<String, String> getHeaders() {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("OrgID", "1270");
        headers.put("APILoginID", "UaQny7QE5PdlWqnPA1o5NQ==");
        headers.put("TransactionKey", "677x4Szy89NbEkRbVk3RfA==");
        headers.put("Accept", "application/json");
        return headers;
    }

}


