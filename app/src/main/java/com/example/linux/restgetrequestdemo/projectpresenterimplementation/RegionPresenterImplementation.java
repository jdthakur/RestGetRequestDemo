package com.example.linux.restgetrequestdemo.projectpresenterimplementation;

import android.util.Log;

import com.example.linux.restgetrequestdemo.ProjectPresenter.RegionPresenter;
import com.example.linux.restgetrequestdemo.projectview.RegionView;
import com.example.linux.restgetrequestdemo.retrofituse.apicall.APIGetService;
import com.example.linux.restgetrequestdemo.retrofituse.model.Region;
import com.example.linux.restgetrequestdemo.retrofituse.projectconstant.RetrofitConstant;
import com.example.linux.restgetrequestdemo.retrofituse.retrofitmaincall.ServiceGenerator;

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

    List<Region> mRegions = new ArrayList<>();

    public RegionPresenterImplementation(RegionView mRegionView) {
        this.mRegionView = mRegionView;
    }

    @Override
    public void loadRegions() {

        mRegionView.onRegionProgress();

        mRegion = ServiceGenerator.getDataFromAPI(RetrofitConstant.mBaseUrl);
        mApiGetService = mRegion.create(APIGetService.class);


        mResult = mApiGetService.getData(ServiceGenerator.getHeaders());

        mResult.enqueue(new Callback<List<Region>>() {
            @Override
            public void onResponse(Call<List<Region>> call, Response<List<Region>> response) {
                mRegions.clear();
                mRegions.addAll(response.body());
                mRegionView.onRegionSuccess(mRegions);
                mRegionView.onRegionDismiss();
            }

            @Override
            public void onFailure(Call<List<Region>> call, Throwable t) {
                Log.d("RegionImplementation", "Fail");
                mRegionView.onRegionError("Get Error In API Call");
                mRegionView.onRegionDismiss();

            }
        });
    }

}
