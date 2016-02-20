package com.shixipai.ui.jobClassify.jobClassifyDetail;


/**
 * Created by xiepeng on 16/2/20.
 */
public interface OnPostJobCallback {
    void onPostJobSuccess(boolean result);

    void onPostJobFailed(String errorString);
}
