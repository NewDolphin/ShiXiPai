package com.shixipai.interactor.search;

import android.content.Context;

import com.shixipai.ui.common.job.OnGetJobItemsCallback;

/**
 * Created by xiepeng on 16/2/3.
 */
public interface SearchInteractor {
    void getJobItems(Context context, int page, String cityCondition, String jobCondition
            ,OnGetJobItemsCallback onGetExploreItemsCallback);

    void cancelRequest(Context context);
}
