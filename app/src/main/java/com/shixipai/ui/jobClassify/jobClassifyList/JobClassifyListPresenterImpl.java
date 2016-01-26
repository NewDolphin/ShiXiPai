package com.shixipai.ui.jobClassify.jobClassifyList;

import android.view.View;

import com.shixipai.R;
import com.shixipai.bean.JobItem;
import com.shixipai.bean.JobResponse;
import com.shixipai.interactor.JobClassifyListInteractor;
import com.shixipai.support.ResourceHelper;
import com.shixipai.ui.common.job.OnGetJobItemsCallback;

import java.util.List;

/**
 * Created by xiepeng on 16/1/23.
 */
public class JobClassifyListPresenterImpl implements JobClassifyListPresenter, OnGetJobItemsCallback {

    private JobClassifyListView jobClassifyListView;
    private JobClassifyListInteractor interactor;

    private boolean isFirstTimeLoad = true;
    private boolean isRefreshing = false;
    private boolean isLoadMore = false;

    private int page = 1;

    public JobClassifyListPresenterImpl(JobClassifyListView jobListView, JobClassifyListInteractor jobInteractor) {
        this.jobClassifyListView = jobListView;
        this.interactor = jobInteractor;
    }

    //刷新时使用
    @Override
    public void loadJobItems(int type) {
        if(isRefreshing){return;}
        this.jobClassifyListView.startRefresh();
        page = 1;
        getJobItems(type);
    }

    //第一次进入这个fragment时加载
    @Override
    public void firstTimeLoadJobItems(int type) {
        isRefreshing = true;
        page = 1;
        jobClassifyListView.showFooter();
        getJobItems(type);
    }

    private void getJobItems(int type) {
        this.interactor.getJobItems(page,type, this);
    }

    //上拉加载更多的时候
    @Override
    public void loadMoreJobItems(int type) {
        if(isLoadMore){return;}
        page += 1;
        isLoadMore = true;
        jobClassifyListView.showFooter();
        getJobItems(type);

    }

    @Override
    public void onItemClicked(View v, int position) {
        switch (v.getId()) {
            case R.id.bt_job_item_commit:
                jobClassifyListView.startJobDetailActivity(position);
                break;
        }
    }

    @Override
    public void onSuccess(JobResponse jobResponse) {
        this.jobClassifyListView.stopRefresh();

        if (jobResponse.rows.size() > 0) {
            List<JobItem> items = jobResponse.rows;
            if (isLoadMore) {
                jobClassifyListView.addListData(items);
                isLoadMore = false;
            } else {
                jobClassifyListView.updateListData(items);
                if(isFirstTimeLoad){
                    jobClassifyListView.hideFooter();
                    isFirstTimeLoad = !isFirstTimeLoad;
                }
            }
        } else {
            jobClassifyListView.hideFooter();
            this.jobClassifyListView.toastMessage(ResourceHelper.getString(R.string.no_more_information));
        }
        isLoadMore = false;
        isRefreshing = false;
    }


    @Override
    public void onFailed(String errorString) {
        page -= 1;
        this.jobClassifyListView.stopRefresh();
        this.jobClassifyListView.toastMessage(errorString);
        isLoadMore = false;
        isRefreshing = false;
    }
}
