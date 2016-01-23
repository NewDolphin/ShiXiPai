package com.shixipai.ui.job.list;

import android.view.View;

import com.shixipai.R;
import com.shixipai.bean.JobItem;
import com.shixipai.bean.JobResponse;
import com.shixipai.interactor.JobInteractor;
import com.shixipai.support.ResourceHelper;
import com.shixipai.ui.common.OnGetJobItemsCallback;

import java.util.List;


/**
 * Created by xiepeng on 16/1/19.
 */
public class JobListPresenterImpl implements JobListPresenter, OnGetJobItemsCallback {

    private final static String LOG_TAG = JobListPresenterImpl.class.getSimpleName();

    private JobListView jobListView;
    private JobInteractor jobInteractor;

    private boolean isFirstTimeLoad = true;
    private boolean isRefreshing = false;
    private boolean isLoadMore = false;

    private int page = 1;

    public JobListPresenterImpl(JobListView jobListView, JobInteractor jobInteractor) {
        this.jobListView = jobListView;
        this.jobInteractor = jobInteractor;
    }

    //fragment刷新时使用
    @Override
    public void loadJobItems(int type) {
        if(isRefreshing){return;}
        this.jobListView.startRefresh();
        page = 1;
        getJobItems(type);
    }

    //第一次进入这个fragment时加载
    @Override
    public void firstTimeLoadJobItems(int type) {
        isRefreshing = true;
        page = 1;
        jobListView.showFooter();
        getJobItems(type);
    }

    private void getJobItems(int type) {
        switch (type) {
            //职位推荐
            case 0:
                this.jobInteractor.getJobItems(page, this);
                break;
            //已投递纪录
//            case 1:
//                this.jobInteractor.getJobItems(page, this);
//                break;
        }
    }

    //上拉加载更多的时候
    @Override
    public void loadMoreJobItems(int type) {
        if(isLoadMore){return;}
        page += 1;
        isLoadMore = true;
        jobListView.showFooter();
        getJobItems(type);

    }

    @Override
    public void onItemClicked(View v, int position) {
//        switch (v.getId()) {
//            case R.id.tv_home_item_username:
//                _jobListView.startProfileActivity(position);
//                break;
//            case R.id.iv_home_item_avatar:
//                _jobListView.startProfileActivity(position);
//                break;
//            case R.id.tv_home_item_title:
//                _jobListView.startQuestionArticlActivity(position);
//                break;
//            case R.id.tv_home_item_content:
//                _jobListView.startQuestionArticlActivity(position);
//                break;
//        }
    }

    @Override
    public void onSuccess(JobResponse exploreResponse) {
//        this.jobListView.stopRefresh();
//
//        if (exploreResponse.total_rows > 0) {
//            List<JobItem> items = exploreResponse.rows;
//            if (isLoadMore) {
//                jobListView.addListData(items);
//                isLoadMore = false;
//            } else {
//                jobListView.updateListData(items);
//                if(isFirstTimeLoad){
//                    jobListView.hideFooter();
//                    isFirstTimeLoad = !isFirstTimeLoad;
//                }
//            }
//        } else {
//            jobListView.hideFooter();
//            this.jobListView.toastMessage(ResourceHelper.getString(R.string.no_more_information));
//        }
//        isLoadMore = false;
//        isRefreshing = false;
    }


    @Override
    public void onFailed(String errorString) {
        page -= 1;
        this.jobListView.stopRefresh();
        this.jobListView.toastMessage(errorString);
        isLoadMore = false;
        isRefreshing = false;
    }
}
