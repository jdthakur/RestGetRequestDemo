package com.example.linux.restgetrequestdemo.projectpresenterimplementation;

import android.os.AsyncTask;
import android.util.Log;

import com.example.linux.restgetrequestdemo.ProjectPresenter.RegionPresenter;
import com.example.linux.restgetrequestdemo.projectview.RegionView;
import com.example.linux.restgetrequestdemo.retrofituse.apicall.APIGetService;
import com.example.linux.restgetrequestdemo.retrofituse.model.Region;
import com.example.linux.restgetrequestdemo.retrofituse.projectconstant.RetrofitConstant;
import com.example.linux.restgetrequestdemo.retrofituse.retrofitmaincall.ServiceGenerator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by linux on 28/8/17.
 */

public class RegionPresenterImplementation implements RegionPresenter {

    Retrofit mRegion;

    List<Region> mFinalRegion;
    Call<List<Region>> mResult;
    APIGetService mApiGetService;


    RegionView mRegionView;

    Response<List<Region>> mFresponse;

    public RegionPresenterImplementation(RegionView mRegionView) {
        this.mRegionView = mRegionView;
    }

    @Override
    public List<Region> getRegion() {

        mRegionView.onRegionProgress();

        mRegion = ServiceGenerator.getDataFromAPI(RetrofitConstant.mBaseUrl);
        mApiGetService = mRegion.create(APIGetService.class);

        mResult = mApiGetService.getData();

        mResult.enqueue(new Callback<List<Region>>()
        {
            @Override
            public void onResponse(Call<List<Region>> call, Response<List<Region>> response) {

                mFresponse = response;
                AsyncRegin mLocRegion = new AsyncRegin();

                mLocRegion.execute();




            }

            @Override
            public void onFailure(Call<List<Region>> call, Throwable t) {
                Log.d("RegionImplementation","Fail");
                mRegionView.onRegionError("Get Error In API Call");
                mRegionView.onRegionDismiss();

            }
        });




        return mFinalRegion;
    }



     public class AsyncRegin extends AsyncTask<Void,Void,Void>{



        @Override
        protected Void doInBackground(Void... params)
        {

            int StatusCode = mFresponse.code();

            Log.d("RegionImplementation",""+StatusCode);

            mFinalRegion = mFresponse.body();

            Log.d("Item",mFinalRegion.toString());


            mRegionView.onRegionSuccessful("Get All Regions");



            return null;
        }
    };




}
