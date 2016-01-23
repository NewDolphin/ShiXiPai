package com.shixipai.ui.jobClassify.jobClassifyList;

import com.shixipai.bean.JobItem;

import java.util.List;

/**
 * Created by xiepeng on 16/1/23.
 */
public interface JobClassifyListView {
    //控制swipeRefreshLayout刷新显示
    void startRefresh();

    //控制swipeRefreshLayout刷新显示
    void stopRefresh();

    void toastMessage(String msg);

    //刷新后,更新列表
    void updateListData(List<JobItem> items);

    //上拉加载更多
    void addListData(List<JobItem> items);

    //
    void startJobDetailActivity(int position);

    //是否显示底部加载进度条
    void showFooter();

    //是否显示底部加载进度条
    void hideFooter();
}
