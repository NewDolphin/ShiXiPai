package com.shixipai.interactor.jobfeedback;

import android.content.Context;

import com.shixipai.ui.jobFeedback.list.OnGetJobFeedbackCallback;

/**
 * Created by xiepeng on 16/2/24.
 */
public interface JobFeedbackInteractor {
    void getJobFeedbackItems(Context context, int page, OnGetJobFeedbackCallback callback);

    void cancelRequest(Context context);
}
