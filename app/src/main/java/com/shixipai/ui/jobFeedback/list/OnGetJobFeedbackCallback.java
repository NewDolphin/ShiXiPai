package com.shixipai.ui.jobFeedback.list;

import com.shixipai.bean.jobfeedback.JobFeedBack;

import java.util.ArrayList;

/**
 * Created by xiepeng on 16/2/24.
 */
public interface OnGetJobFeedbackCallback {
    void onSuccess(ArrayList<JobFeedBack> list);

    void onFailed(String errorString);
}
