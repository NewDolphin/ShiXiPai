package com.shixipai.ui.strategy.list;

import android.view.View;

/**
 * Created by xiepeng on 16/2/6.
 */
public interface StrategyListPresenter {
    //第一次进入时加载
    void firstTimeLoadStrategyItems();

    //上拉加载更多的时候
    void loadMoreStrategyItems();

    //view层也有这个函数，在view中点击事件有presenter处理
    void onItemClicked(View v, int position);
}
