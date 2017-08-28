package com.example.linux.restgetrequestdemo.retrofituse.customadapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.linux.restgetrequestdemo.R;
import com.example.linux.restgetrequestdemo.retrofituse.model.Region;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linux on 28/8/17.
 */

public class RetrofitAdapter extends ArrayAdapter<Region> {

    private Context mContext;
    private List<Region> mRegionList= new ArrayList<>();


    public RetrofitAdapter(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId, @NonNull List<Region> objects) {
        super(context, resource, textViewResourceId, objects);
        mContext = context;
        mRegionList = objects;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        super.getView(position, convertView, parent);

        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.list_regin,parent,false);
        Region region = mRegionList.get(position);
        TextView tv = (TextView) view.findViewById(R.id.txt_Region);
        tv.setText("Region Id "+region.getID()+" R Name:"+region.getName()+" User:"+region.getNumberOfUsers());

        return view;
    }
}
