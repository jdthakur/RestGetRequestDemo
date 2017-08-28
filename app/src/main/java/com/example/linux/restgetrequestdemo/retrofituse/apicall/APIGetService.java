package com.example.linux.restgetrequestdemo.retrofituse.apicall;

import com.example.linux.restgetrequestdemo.retrofituse.model.Region;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by linux on 28/8/17.
 */

public interface APIGetService {



    @Headers({"OrgID:1270",
              "APILoginID:UaQny7QE5PdlWqnPA1o5NQ==",
            "TransactionKey:677x4Szy89NbEkRbVk3RfA==",
            "Accept:application/json"})
    @GET("/api/organizations/1270/regions")
    public Call<List<Region>> getData();


}
