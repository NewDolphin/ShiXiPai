package com.shixipai.ui.feedback;

import android.content.Context;

/**
 * Created by xiepeng on 16/2/25.
 */
public interface FeedbackPresenter {
    void sendAdvice(Context context, String email, String advice);
}
