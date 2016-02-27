package com.shixipai.ui.jobClassify.jobClassifyDetail;

/**
 * Created by xiepeng on 16/2/27.
 */
public interface OnCollectJobCallback {
    void onCollectJobSuccess(boolean result);

    void onCollectJobFailed(String errorString);
}
