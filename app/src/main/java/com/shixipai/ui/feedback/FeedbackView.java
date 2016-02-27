package com.shixipai.ui.feedback;

/**
 * Created by xiepeng on 16/2/25.
 */
public interface FeedbackView {
    void toastMessage(String msg);

    void sendSuccess();

    void showProgress();

    void hideProgress();
}
