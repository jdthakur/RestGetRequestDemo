package com.example.linux.restgetrequestdemo.projectactivities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.linux.restgetrequestdemo.ProjectPresenter.RegionPresenter;
import com.example.linux.restgetrequestdemo.R;
import com.example.linux.restgetrequestdemo.projectpresenterimplementation.RegionPresenterImplementation;
import com.example.linux.restgetrequestdemo.projectview.RegionView;
import com.example.linux.restgetrequestdemo.retrofituse.customadapter.RegionsAdapter;
import com.example.linux.restgetrequestdemo.retrofituse.model.Region;
import com.example.linux.restgetrequestdemo.utility.ProjectUtility;

import java.util.ArrayList;
import java.util.List;

public class RetrofitActivity extends AppCompatActivity implements RegionView {


    ProgressDialog mProgressDialog;

    RegionPresenter mRegionPresenter;

    List<Region> mRegions;

    private RecyclerView rvRegions;

    RegionsAdapter mRegionsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        mRegions = new ArrayList<Region>();

        mRegionPresenter = new RegionPresenterImplementation(this);
        initRecyclerView();
        mRegionPresenter.loadRegions();
    }

    void initRecyclerView() {
        mRegions = new ArrayList<>();
        rvRegions = (RecyclerView) findViewById(R.id.rev_regions);
        rvRegions.setLayoutManager(new LinearLayoutManager(this));
        mRegionsAdapter = new RegionsAdapter(mRegions, this);
        rvRegions.setAdapter(mRegionsAdapter);
    }


    @Override
    public void onRegionProgress() {
        mProgressDialog = ProjectUtility.progressDialogForAll(this);
        mProgressDialog.show();
    }

    @Override
    public void onRegionSuccessful(String success) {

        ProjectUtility.showToast(this, success);
    }

    @Override
    public void onRegionDismiss() {

        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void onRegionError(String errMsg) {
        ProjectUtility.showToast(this, errMsg);
    }

    @Override
    public void onRegionSuccess(List<Region> regions) {
        mRegions.clear();
        mRegions.addAll(regions);
        mRegionsAdapter.notifyDataSetChanged();
    }
}
