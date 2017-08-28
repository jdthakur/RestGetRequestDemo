package com.example.linux.restgetrequestdemo.projectactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.linux.restgetrequestdemo.R;
import com.example.linux.restgetrequestdemo.oldway.RestAPIPutAsync;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        RestAPIGetAsync locObj = new RestAPIGetAsync();
//        locObj.execute();


//          RestAPIPutAsync locput = new RestAPIPutAsync();
//          locput.execute();


        Intent mRetrofit  = new Intent(MainActivity.this,RetrofitActivity.class);
        startActivity(mRetrofit);


    }
}
