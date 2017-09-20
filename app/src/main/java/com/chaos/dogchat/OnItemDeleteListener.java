package com.chaos.dogchat;

import android.view.View;

/**
 * Created by yc.Zhao on 2017/9/19 0019.
 */

public interface OnItemDeleteListener {
    void onSignClick(int position);

    /**
     * 删除按钮回调
     *
     * @param position
     */
    void onDeleteClick(int position);
}
