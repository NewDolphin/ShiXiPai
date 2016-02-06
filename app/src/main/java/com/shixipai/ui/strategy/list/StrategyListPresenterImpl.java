package com.shixipai.ui.strategy.list;

import android.view.View;

import com.shixipai.R;
import com.shixipai.bean.strategy.StrategyItem;
import com.shixipai.interactor.interview.InterviewTopicInteractor;
import com.shixipai.interactor.search.SearchInteractor;
import com.shixipai.interactor.strategy.StrategyInteractor;
import com.shixipai.support.ResourceHelper;
import com.shixipai.ui.interview.topic.InterviewTopicView;

import java.util.ArrayList;

/**
 * Created by xiepeng on 16/2/6.
 */
public class StrategyListPresenterImpl implements StrategyListPresenter ,OnGetStrategyItemCallback{
    private StrategyListView strategyListView;
    private StrategyInteractor interactor;

    private boolean isFirstTimeLoad = true;
    private boolean isLoadMore = false;

    private int page = 1;

    public StrategyListPresenterImpl(StrategyListView strategyListView, StrategyInteractor strategyInteractor) {
        this.strategyListView = strategyListView;
        this.interactor = strategyInteractor;
    }

    @Override
    public void firstTimeLoadStrategyItems() {
        page = 1;
        strategyListView.showFooter();
        getStrategyItems();
    }

    @Override
    public void loadMoreStrategyItems() {
        if(isLoadMore){return;}
        page += 1;
        isLoadMore = true;
        strategyListView.showFooter();
        getStrategyItems();
    }

    @Override
    public void onItemClicked(View v, int position) {
        switch (v.getId()) {
            case R.id.layout_strategy_list:
                strategyListView.startStrategyDetailActivity(position);
                break;
        }
    }

    @Override
    public void onSuccess(ArrayList<StrategyItem> list) {
        if (list.size() > 0) {
            if(isFirstTimeLoad){
                strategyListView.addListData(list);
                strategyListView.hideFooter();
                isFirstTimeLoad = !isFirstTimeLoad;
            }else {
                strategyListView.addListData(list);
                isLoadMore = false;
            }
        } else {
            strategyListView.hideFooter();
            this.strategyListView.toastMessage(ResourceHelper.getString(R.string.no_more_information));
        }
        isLoadMore = false;
    }

    @Override
    public void onFailed(String errorString) {
        page -= 1;
        this.strategyListView.toastMessage(errorString);
        isLoadMore = false;
    }

    private void getStrategyItems() {
        this.interactor.getStrategyItems(page, this);
    }
}
