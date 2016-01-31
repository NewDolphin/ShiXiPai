package com.shixipai.ui.interview.topic;

import com.shixipai.bean.interview.InterviewTopicItem;

import java.util.ArrayList;

/**
 * Created by xiepeng on 16/1/30.
 */

//用于recyclerview
public interface OnGetInterviewListItemCallback {
    void onSuccess(ArrayList<InterviewTopicItem> list);

    void onFailed(String errorString);
}
