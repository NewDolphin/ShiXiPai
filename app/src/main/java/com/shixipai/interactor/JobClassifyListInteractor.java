package com.shixipai.interactor;

import com.shixipai.ui.common.OnGetJobItemsCallback;

/**
 * Created by xiepeng on 16/1/23.
 */
public interface JobClassifyListInteractor {
    void getJobItems(int page, int type ,OnGetJobItemsCallback onGetExploreItemsCallback);
}
