package com.shixipai.ui.feedback;

import android.content.Context;

import com.shixipai.interactor.feedback.FeedbackInteractor;
import com.shixipai.support.PrefUtils;

/**
 * Created by xiepeng on 16/2/25.
 */
public class FeedbackPresenterImpl implements FeedbackPresenter, OnSendAdviceCallback {
    private FeedbackView feedbackView;
    private FeedbackInteractor interactor;

    public FeedbackPresenterImpl(FeedbackView feedbackView, FeedbackInteractor interactor) {
        this.feedbackView = feedbackView;
        this.interactor = interactor;
    }

    @Override
    public void sendAdvice(Context context, String email, String advice) {
        interactor.sendFeedbackInfo(context, email, advice, this);
    }

    @Override
    public void onSendAdviceSuccess(boolean result) {
        if (result){
            feedbackView.hideProgress();
            feedbackView.sendSuccess();
        }
    }

    @Override
    public void onSendAdviceFailed(String errorString) {

    }
}
