package com.shixipai.ui.home;

import android.view.View;

import com.shixipai.R;
import com.shixipai.bean.JobItem;
import com.shixipai.bean.JobResponse;
import com.shixipai.interactor.home.HomeInteractor;
import com.shixipai.support.ResourceHelper;
import com.shixipai.ui.common.job.OnGetJobItemsCallback;

import java.util.List;

/**
 * Created by xiepeng on 16/1/26.
 */
public class HomeListPresenterImpl implements HomeListPresenter,OnGetJobItemsCallback{
    private HomeView homeView;
    private HomeInteractor interactor;

    private boolean isFirstTimeLoad = true;
    private boolean isLoadMore = false;

    private int page = 1;

    public HomeListPresenterImpl(HomeView homeView, HomeInteractor interactor) {
        this.homeView = homeView;
        this.interactor = interactor;
    }


    @Override
    public void firstTimeLoadJobItems() {
        page = 1;
        homeView.showFooter();
        getJobItems();
    }

    @Override
    public void loadMoreJobItems() {
        if(isLoadMore){return;}
        page += 1;
        isLoadMore = true;
        homeView.showFooter();
        getJobItems();
    }

    @Override
    public void onItemClicked(View v, int position) {

    }

    private void getJobItems() {
//        this.interactor.getJobItems(page,type, this);
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
}
