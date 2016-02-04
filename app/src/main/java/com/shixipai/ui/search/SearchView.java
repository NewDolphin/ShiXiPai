package com.shixipai.ui.search;

import android.content.Context;

import com.shixipai.bean.JobItem;
import com.shixipai.bean.interview.InterviewTopicItem;

import java.util.List;

/**
 * Created by xiepeng on 16/2/3.
 */
public interface SearchView {
    void toastMessage(String msg);

    //上拉加载更多
    void addListData(List<JobItem> items);

    //是否显示底部加载进度条
    void showFooter();

    //是否显示底部加载进度条
    void hideFooter();

    void startJobDetailActivity(int position);

    Context getContext();
}
