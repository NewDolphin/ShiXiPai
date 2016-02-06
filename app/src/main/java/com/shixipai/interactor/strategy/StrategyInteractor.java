package com.shixipai.interactor.strategy;

import com.shixipai.ui.interview.topic.OnGetInterviewListItemCallback;
import com.shixipai.ui.strategy.list.OnGetStrategyItemCallback;

/**
 * Created by xiepeng on 16/2/6.
 */
public interface StrategyInteractor {
    void getStrategyItems(int page, OnGetStrategyItemCallback onGetStrategyItemCallback);
}
