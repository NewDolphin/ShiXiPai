package com.shixipai.ui.home;

import android.content.Context;
import android.view.View;

import com.shixipai.R;
import com.shixipai.bean.JobItem;
import com.shixipai.bean.JobResponse;
import com.shixipai.interactor.home.HomeInteractor;
import com.shixipai.interactor.search.SearchInteractor;
import com.shixipai.support.ResourceHelper;
import com.shixipai.ui.common.job.OnGetJobItemsCallback;
import com.shixipai.ui.search.SearchView;

import java.util.List;

/**
 * Created by xiepeng on 16/1/26.
 */
public class HomeListPresenterImpl implements HomeListPresenter,OnGetJobItemsCallback{
    private HomeView homeView;
    private SearchInteractor interactor;

    private boolean isFirstTimeLoad = true;
    private boolean isLoadMore = false;

    private int page = 1;

    public HomeListPresenterImpl(HomeView homeView, SearchInteractor searchInteractor) {
        this.homeView = homeView;
        this.interactor = searchInteractor;
    }

    @Override
    public void firstTimeLoadJobItems(String cityCondition,String jobCondition) {
        page = 1;
        homeView.showFooter();
        getJobItems(homeView.getContext(),cityCondition,jobCondition);
    }

    @Override
    public void loadMoreJobItems(String cityCondition,String jobCondition) {
        if(isLoadMore){return;}
        page += 1;
        isLoadMore = true;
        homeView.showFooter();
        getJobItems(homeView.getContext(),cityCondition, jobCondition);
    }

    @Override
    public void onItemClicked(View v, int position) {
        switch (v.getId()) {
            case R.id.bt_job_item_commit:
                homeView.startJobDetailActivity(position);
                break;
        }
    }

    @Override
    public void cancelRequest(Context context) {
        interactor.cancelRequest(context);
    }

    @Override
    public void onSuccess(JobResponse jobResponse) {
        if (jobResponse.rows.size() > 0) {
            List<JobItem> items = jobResponse.rows;
            if(isFirstTimeLoad){
                homeView.addListData(items);
                homeView.hideFooter();
                isFirstTimeLoad = !isFirstTimeLoad;
            }else {
                homeView.addListData(items);
                isLoadMore = false;
            }
        } else {
            homeView.hideFooter();
            this.homeView.toastMessage(ResourceHelper.getString(R.string.no_more_information));
        }
        isLoadMore = false;
    }

    @Override
    public void onFailed(String errorString) {
        page -= 1;
        this.homeView.toastMessage(errorString);
        isLoadMore = false;
    }

    private void getJobItems(Context context,String cityCondition,String jobCondition) {
        this.interactor.getJobItems(context,page,cityCondition,jobCondition, this);
    }
}
