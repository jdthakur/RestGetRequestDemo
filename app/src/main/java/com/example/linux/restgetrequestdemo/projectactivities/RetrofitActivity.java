package com.example.linux.restgetrequestdemo.projectactivities;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.os.Bundle;

import com.example.linux.restgetrequestdemo.ProjectPresenter.RegionPresenter;
import com.example.linux.restgetrequestdemo.R;
import com.example.linux.restgetrequestdemo.projectpresenterimplementation.RegionPresenterImplementation;
import com.example.linux.restgetrequestdemo.projectview.RegionView;
import com.example.linux.restgetrequestdemo.retrofituse.customadapter.RetrofitAdapter;
import com.example.linux.restgetrequestdemo.retrofituse.model.Region;
import com.example.linux.restgetrequestdemo.retrofituse.projectconstant.RetrofitConstant;
import com.example.linux.restgetrequestdemo.retrofituse.retrofitmaincall.ServiceGenerator;
import com.example.linux.restgetrequestdemo.utility.ProjectUtility;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;

public class RetrofitActivity extends ListActivity implements RegionView {


    ProgressDialog mProgressDialog;
    RegionPresenter mRegionPresenter;
    List<Region> mRegin = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mRegin = new ArrayList<Region>();

        mRegionPresenter = new RegionPresenterImplementation(this);

        mRegin = mRegionPresenter.getRegion();

        setListAdapter(new RetrofitAdapter(this, R.layout.list_regin,R.id.txt_Region,mRegin));

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

        ProjectUtility.showToast(this,errMsg);
    }
}
