package com.example.linux.restgetrequestdemo.retrofituse.apicall;

import com.example.linux.restgetrequestdemo.retrofituse.model.Region;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;

/**
 * Created by linux on 28/8/17.
 */

public interface APIGetService {


    @GET("/api/organizations/1270/regions")
    Call<List<Region>> getData(@HeaderMap HashMap<String,String> headerMap);


}
