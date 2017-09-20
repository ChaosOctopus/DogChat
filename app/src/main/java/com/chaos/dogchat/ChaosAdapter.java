package com.chaos.dogchat;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yc.Zhao on 2017/9/19 0019.
 */

public class ChaosAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private List<DogBean> mList;
    private LinearLayout linearLayout;
    private MyViewHolder viewHolder;

    public ChaosAdapter(Context mContext, List<DogBean> mList) {
        this.mContext = mContext;
        mInflater = LayoutInflater.from(mContext);
        this.mList = mList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(mInflater.inflate(R.layout.item_recyclerview, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        viewHolder = (MyViewHolder) holder;
        linearLayout=viewHolder.layout;
        viewHolder.content.setText(mList.get(position).getContent());
        viewHolder.name.setText(mList.get(position).getName());
        Glide.with(mContext).load(mList.get(position).getType()).transform(new BitmapCircleTransformation(mContext)).into(viewHolder.imageView);

    }

    @Override
    public int getItemCount() {
        return mList != null ? mList.size() : 0;
    }

    public void removeItem(int position) {
        mList.remove(position);
        notifyDataSetChanged();
    }
    public void toTopItem(int position){
        DogBean dog = new DogBean();
        dog=mList.get(position);
        mList.remove(position);
        mList.add(0,dog);
        notifyDataSetChanged();

    }
}
