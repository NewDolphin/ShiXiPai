package com.shixipai.ui.jobcollect;

import android.content.Context;
import android.view.View;

import com.shixipai.R;
import com.shixipai.bean.JobItem;
import com.shixipai.bean.JobResponse;
import com.shixipai.interactor.jobcollect.JobCollectInteractor;
import com.shixipai.support.ResourceHelper;
import com.shixipai.ui.common.job.OnGetJobItemsCallback;

import java.util.List;

/**
 * Created by xiepeng on 16/2/26.
 */
public class JobCollectPresenterImpl implements JobCollectPresenter,OnGetJobItemsCallback {
    private JobCollectView jobCollectView;
    private JobCollectInteractor interactor;

    private boolean isFirstTimeLoad = true;
    private boolean isLoadMore = false;

    private int page = 1;

    public JobCollectPresenterImpl(JobCollectView jobCollectView, JobCollectInteractor jobCollectInteractor) {
        this.jobCollectView = jobCollectView;
        this.interactor = jobCollectInteractor;
    }

    @Override
    public void firstTimeLoadJobItems() {
        page = 1;
        jobCollectView.showFooter();
        getJobItems(jobCollectView.getContext());
    }

    @Override
    public void loadMoreJobItems() {
        if(isLoadMore){return;}
        page += 1;
        isLoadMore = true;
        jobCollectView.showFooter();
        getJobItems(jobCollectView.getContext());
    }

    @Override
    public void onItemClicked(View v, int position) {
        switch (v.getId()) {
            case R.id.cardview_job_list_item:
                jobCollectView.startJobDetailActivity(position);
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
                jobCollectView.addListData(items);
                jobCollectView.hideFooter();
                isFirstTimeLoad = !isFirstTimeLoad;
            }else {
                jobCollectView.addListData(items);
                isLoadMore = false;
            }
        } else {
            jobCollectView.hideFooter();
            this.jobCollectView.toastMessage(ResourceHelper.getString(R.string.no_more_information));
        }
        isLoadMore = false;
    }

    @Override
    public void onFailed(String errorString) {
        page -= 1;
        this.jobCollectView.toastMessage(errorString);
        isLoadMore = false;
    }

    private void getJobItems(Context context) {
        this.interactor.getJobItems(context,page,this);
    }
}
