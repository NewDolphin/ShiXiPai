package com.shixipai.interactor.interview;

import com.shixipai.ui.common.job.OnGetJobItemsCallback;
import com.shixipai.ui.interview.topic.OnGetInterviewListItemCallback;

/**
 * Created by xiepeng on 16/1/30.
 */
public interface InterviewTopicInteractor {
    void getJobItems(int page, int type ,OnGetInterviewListItemCallback onGetInterviewListItemCallback);
}
