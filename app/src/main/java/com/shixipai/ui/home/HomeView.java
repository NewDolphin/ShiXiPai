package com.shixipai.ui.home;

import com.shixipai.bean.JobItem;

import java.util.List;

/**
 * Created by xiepeng on 16/1/25.
 */
public interface HomeView {

    //上拉加载更多
    void addListData(List<JobItem> items);

    //
    void startJobDetailActivity(int position);

    //是否显示底部加载进度条
    void showFooter();

    //是否显示底部加载进度条
    void hideFooter();
    void toastMessage(String msg);
}
