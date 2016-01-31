package com.shixipai.ui.interview.question;

import com.shixipai.bean.interview.InterviewQuestionItem;

import java.util.ArrayList;

/**
 * Created by xiepeng on 16/1/31.
 */
public interface OnGetInterviewQuestionCallback {
    void onSuccess(ArrayList<InterviewQuestionItem> list);

    void onFailed(String errorString);
}
