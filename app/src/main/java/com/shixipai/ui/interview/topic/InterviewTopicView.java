package com.shixipai.ui.interview.topic;

import com.shixipai.bean.interview.InterviewTopicItem;

import java.util.List;

/**
 * Created by xiepeng on 16/1/30.
 */
public interface InterviewTopicView {
    void toastMessage(String msg);

    //上拉加载更多
    void addListData(List<InterviewTopicItem> items);

    //是否显示底部加载进度条
    void showFooter();

    //是否显示底部加载进度条
    void hideFooter();

    void startInterviewQuestionActivity(int postion);
}
