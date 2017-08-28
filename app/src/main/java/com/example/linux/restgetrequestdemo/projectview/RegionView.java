package com.example.linux.restgetrequestdemo.projectview;

/**
 * Created by linux on 28/8/17.
 */

public interface RegionView {

    void onRegionProgress();
    void onRegionSuccessful(String success);
    void onRegionDismiss();
    void onRegionError(String errMsg);
}
