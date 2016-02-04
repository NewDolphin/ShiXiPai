package com.shixipai.interactor.job;

import com.shixipai.ui.common.job.OnGetJobItemsCallback;

/**
 * Created by xiepeng on 16/1/23.
 */
public interface JobClassifyListInteractor {
    void getJobItems(int page, int type ,OnGetJobItemsCallback onGetExploreItemsCallback);
}
