package com.shixipai.ui.feedback;

/**
 * Created by xiepeng on 16/2/25.
 */
public interface OnSendAdviceCallback {
    void onSendAdviceSuccess(boolean result);

    void onSendAdviceFailed(String errorString);
}
