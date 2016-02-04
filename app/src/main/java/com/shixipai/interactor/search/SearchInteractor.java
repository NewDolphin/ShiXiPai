package com.shixipai.interactor.search;

import com.shixipai.ui.common.job.OnGetJobItemsCallback;

/**
 * Created by xiepeng on 16/2/3.
 */
public interface SearchInteractor {
    void getJobItems(int page, String cityCondition, String jobCondition ,OnGetJobItemsCallback onGetExploreItemsCallback);
}
