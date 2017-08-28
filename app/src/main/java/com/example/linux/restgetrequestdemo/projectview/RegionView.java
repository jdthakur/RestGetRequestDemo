package com.example.linux.restgetrequestdemo.projectview;

import com.example.linux.restgetrequestdemo.retrofituse.model.Region;

import java.util.List;

/**
 * Created by linux on 28/8/17.
 */

public interface RegionView {

    void onRegionProgress();

    void onRegionSuccessful(String success);

    void onRegionDismiss();

    void onRegionError(String errMsg);

    void onRegionSuccess(List<Region> regions);
}
