package com.shixipai.ui.interview.topic;

import android.view.View;

/**
 * Created by xiepeng on 16/1/30.
 */
public interface InterviewTopicPresenter {
    //第一次进入时加载
    void firstTimeLoadJobItems(int classify_id);

    //上拉加载更多的时候
    void loadMoreJobItems(int classify_id);

    //view层也有这个函数，在view中点击事件有presenter处理
    void onItemClicked(View v, int position);
}
