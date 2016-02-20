package com.shixipai.interactor.resume;

import com.shixipai.bean.edit.ResumeInfo;
import com.shixipai.ui.edit.editinfo.want.OnGetPostResultCallback;

/**
 * Created by xiepeng on 16/2/20.
 */
public interface PostResumeInteractor {
    void postResume(ResumeInfo resumeInfo,OnGetPostResultCallback callback);
}
