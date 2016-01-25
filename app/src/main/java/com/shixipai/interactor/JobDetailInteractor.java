package com.shixipai.interactor;

import com.shixipai.ui.common.OnGetJobItemsCallback;
import com.shixipai.ui.jobClassify.jobClassifyDetail.OnGetJobDetailCallback;

/**
 * Created by xiepeng on 16/1/25.
 */
public interface JobDetailInteractor {
    void getJobDetail(int id ,OnGetJobDetailCallback onGetJobDetailCallback);
}
