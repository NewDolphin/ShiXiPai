package com.shixipai.interactor.feedback;

import android.content.Context;

import com.shixipai.ui.feedback.OnSendAdviceCallback;

/**
 * Created by xiepeng on 16/2/25.
 */
public interface FeedbackInteractor {
    void sendFeedbackInfo(Context context, String email, String advice, OnSendAdviceCallback callback);

    void cancelRequest(Context context);
}
