package com.example.linux.restgetrequestdemo.retrofituse.customadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.linux.restgetrequestdemo.R;
import com.example.linux.restgetrequestdemo.retrofituse.model.Region;

import java.util.List;

/**
 * Created by rohan on 8/28/17.
 */

public class RegionsAdapter extends RecyclerView.Adapter<RegionsAdapter.RegionViewHolder> {

    private List<Region> mRegions;

    private Context mContext;

    public RegionsAdapter(List<Region> regions, Context context) {
        mRegions = regions;
        mContext = context;
    }

    @Override
    public RegionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RegionViewHolder(LayoutInflater.from(mContext)
                .inflate(R.layout.list_regin, parent, false));
    }

    @Override
    public void onBindViewHolder(RegionViewHolder holder, int position) {
        holder.txtTitle.setText(getItem(position).getName());
    }

    private Region getItem(int pos) {
        return mRegions.get(pos);
    }

    @Override
    public int getItemCount() {
        return mRegions.size();
    }

    public class RegionViewHolder extends RecyclerView.ViewHolder {

        private TextView txtTitle;

        public RegionViewHolder(View itemView) {
            super(itemView);
            txtTitle = (TextView) itemView.findViewById(R.id.txt_Region);

        }
    }
}
