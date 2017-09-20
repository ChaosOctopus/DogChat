package com.chaos.dogchat;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by yc.Zhao on 2017/9/19 0019.
 */

public class MyViewHolder extends RecyclerView.ViewHolder {
    public TextView status;
    public ImageView imageView;
    public TextView name;
    public TextView content;
    public TextView delete;
    public LinearLayout layout;
    public MyViewHolder(View itemView) {
        super(itemView);
        name = (TextView) itemView.findViewById(R.id.tv_name);
        content = (TextView) itemView.findViewById(R.id.tv_content);
        delete = (TextView) itemView.findViewById(R.id.tv_delete);
        layout = (LinearLayout) itemView.findViewById(R.id.item_layout);
        imageView = (ImageView) itemView.findViewById(R.id.iv_type);
        status = (TextView) itemView.findViewById(R.id.tv_status);
    }
}
