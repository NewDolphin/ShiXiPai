package com.shixipai.interactor.job;

import com.shixipai.ui.jobClassify.jobClassifyDetail.OnGetJobDetailCallback;
import com.shixipai.ui.jobClassify.jobClassifyDetail.OnPostJobCallback;

/**
 * Created by xiepeng on 16/1/25.
 */
public interface JobDetailInteractor {
    void getJobDetail(int id ,OnGetJobDetailCallback onGetJobDetailCallback);

    void postJob(int id, OnPostJobCallback callback);
}
