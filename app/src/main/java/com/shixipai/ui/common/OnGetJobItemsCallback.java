package com.shixipai.ui.common;

import com.shixipai.bean.JobResponse;

/**
 * Created by xiepeng on 16/1/23.
 */
public interface OnGetJobItemsCallback {
    void onSuccess(JobResponse jobResponse);

    void onFailed(String errorString);
}
