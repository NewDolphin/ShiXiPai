package com.shixipai.ui.job.list;

import android.view.View;

/**
 * Created by xiepeng on 16/1/19.
 */
public interface JobListPresenter {

    //fragment刷新时使用
    void loadJobItems(int type);

    //第一次进入这个fragment时加载
    void firstTimeLoadJobItems(int type);

    //上拉加载更多的时候
    void loadMoreJobItems(int type);

    //view层也有这个函数，在view中点击事件有presenter处理
    void onItemClicked(View v, int position);

}
