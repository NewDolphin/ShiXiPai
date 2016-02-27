package com.shixipai.ui.jobcollect;

import android.content.Context;
import android.view.View;

/**
 * Created by xiepeng on 16/2/26.
 */
public interface JobCollectPresenter {
    //第一次进入时加载
    void firstTimeLoadJobItems();

    //上拉加载更多的时候
    void loadMoreJobItems();

    //view层也有这个函数，在view中点击事件有presenter处理
    void onItemClicked(View v, int position);

    void cancelRequest(Context context);
}
