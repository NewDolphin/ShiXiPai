package com.shixipai.ui.interview.question;

import com.shixipai.bean.interview.InterviewQuestionItem;
import com.shixipai.bean.interview.InterviewTopicItem;

import java.util.List;

/**
 * Created by xiepeng on 16/1/30.
 */
public interface InterviewQuestionView {
    void toastMessage(String msg);

    //上拉加载更多
    void addListData(List<InterviewQuestionItem> items);

    //是否显示底部加载进度条
    void showFooter();

    //是否显示底部加载进度条
    void hideFooter();

    void startInterviewDetailActivity(int postion);

    //添加分割线
    void addItemDecoration();
}
