package com.shixipai.ui.search;

import android.view.View;

/**
 * Created by xiepeng on 16/2/3.
 */
public interface SearchPresenter {
    //第一次进入时加载
    void firstTimeLoadJobItems(String cityCondition,String jobCondition);

    //上拉加载更多的时候
    void loadMoreJobItems(String cityCondition,String jobCondition);

    //view层也有这个函数，在view中点击事件有presenter处理
    void onItemClicked(View v, int position);

}
