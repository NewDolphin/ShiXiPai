package com.shixipai.ui.jobClassify.jobClassifyDetail;

import com.shixipai.bean.JobDetail;

/**
 * Created by xiepeng on 16/1/25.
 */
public interface OnGetJobDetailCallback {
    void onSuccess(JobDetail jobDetail);

    void onFailed(String errorString);
}
