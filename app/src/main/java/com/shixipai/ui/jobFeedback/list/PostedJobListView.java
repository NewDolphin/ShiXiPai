package com.shixipai.ui.jobFeedback.list;

import android.content.Context;

import com.shixipai.bean.jobfeedback.JobFeedBack;

import java.util.List;

/**
 * Created by xiepeng on 16/2/22.
 */
public interface PostedJobListView {
    void toastMessage(String msg);

    //上拉加载更多
    void addListData(List<JobFeedBack> items);

    //是否显示底部加载进度条
    void showFooter();

    //是否显示底部加载进度条
    void hideFooter();

    void startJobFeedbackDetailActivity(int position);

    Context getContext();
}
