package com.shixipai.interactor.jobcollect;

import android.content.Context;

import com.shixipai.ui.common.job.OnGetJobItemsCallback;

/**
 * Created by xiepeng on 16/2/26.
 */
public interface JobCollectInteractor {
    void getJobItems(Context context,int page,OnGetJobItemsCallback onGetJobItemsCallback);

    void cancelRequest(Context context);
}
