package com.shixipai.ui.strategy.list;

import com.shixipai.bean.strategy.StrategyItem;

import java.util.ArrayList;

/**
 * Created by xiepeng on 16/2/6.
 */
public interface OnGetStrategyItemCallback {
    void onSuccess(ArrayList<StrategyItem> list);

    void onFailed(String errorString);
}
