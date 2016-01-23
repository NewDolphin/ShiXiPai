package com.shixipai.interactor;


import com.shixipai.ui.common.OnGetJobItemsCallback;

/**
 * Created by xiepeng on 16/1/19.
 */
public interface JobInteractor {
    void getJobItems(int page, OnGetJobItemsCallback onGetExploreItemsCallback);
}
