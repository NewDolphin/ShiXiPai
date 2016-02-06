package com.shixipai.ui.strategy.list;

import com.shixipai.bean.strategy.StrategyItem;

import java.util.List;

/**
 * Created by xiepeng on 16/2/6.
 */
public interface StrategyListView {
    void toastMessage(String msg);

    //上拉加载更多
    void addListData(List<StrategyItem> items);

    //是否显示底部加载进度条
    void showFooter();

    //是否显示底部加载进度条
    void hideFooter();

    void startStrategyDetailActivity(int postion);
}
