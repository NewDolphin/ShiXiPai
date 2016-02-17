package com.shixipai.ui.resume;

import com.shixipai.bean.edit.ResumeInfo;

/**
 * Created by xiepeng on 16/2/17.
 */
public interface OnGetResumeCallback {
    void onSuccess(ResumeInfo resumeInfo);

    void onFailed(String errorString);
}
