package com.shixipai.ui.interview.question;

import android.view.View;

/**
 * Created by xiepeng on 16/1/31.
 */
public interface InterviewQuestionPresenter {
    //第一次进入时加载
    void firstTimeLoadJobItems(int tid);

    //上拉加载更多的时候
    void loadMoreJobItems(int tid);

    //view层也有这个函数，在view中点击事件有presenter处理
    void onItemClicked(View v, int position);
}
