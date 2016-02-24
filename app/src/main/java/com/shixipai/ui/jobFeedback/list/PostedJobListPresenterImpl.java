package com.shixipai.ui.jobFeedback.list;

import android.content.Context;
import android.view.View;

import com.shixipai.R;
import com.shixipai.bean.JobItem;
import com.shixipai.bean.jobfeedback.JobFeedBack;
import com.shixipai.interactor.jobfeedback.JobFeedbackInteractor;
import com.shixipai.support.ResourceHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiepeng on 16/2/22.
 */
public class PostedJobListPresenterImpl implements PostedJobListPresenter, OnGetJobFeedbackCallback {
    private PostedJobListView postedJobListView;
    private JobFeedbackInteractor interactor;

    private boolean isFirstTimeLoad = true;
    private boolean isLoadMore = false;

    private int page = 1;

    public PostedJobListPresenterImpl(PostedJobListView postedJobListView, JobFeedbackInteractor interactor) {
        this.postedJobListView = postedJobListView;
        this.interactor = interactor;
    }


    @Override
    public void firstTimeLoadJobItems() {
        page = 1;
        postedJobListView.showFooter();
        getJobItems(postedJobListView.getContext());
    }

    @Override
    public void loadMoreJobItems() {
        if(isLoadMore){return;}
        page += 1;
        isLoadMore = true;
        postedJobListView.showFooter();
        getJobItems(postedJobListView.getContext());
    }

    @Override
    public void onItemClicked(View v, int position) {
        switch (v.getId()) {
            case R.id.cardview_job_feedback_list:
                postedJobListView.startJobFeedbackDetailActivity(position);
                break;
        }
    }

    @Override
    public void cancelRequest(Context context) {
        this.interactor.cancelRequest(context);
    }

    private void getJobItems(Context context) {
        this.interactor.getJobFeedbackItems(context,page, this);
    }


    @Override
    public void onSuccess(ArrayList<JobFeedBack> list) {
        if (list.size() > 0) {
            if(isFirstTimeLoad){
                postedJobListView.addListData(list);
                postedJobListView.hideFooter();
                isFirstTimeLoad = !isFirstTimeLoad;
            }else {
                postedJobListView.addListData(list);
                isLoadMore = false;
            }
        } else {
            postedJobListView.hideFooter();
            this.postedJobListView.toastMessage(ResourceHelper.getString(R.string.no_more_information));
        }
        isLoadMore = false;
    }

    @Override
    public void onFailed(String errorString) {
        page -= 1;
        this.postedJobListView.toastMessage(errorString);
        isLoadMore = false;
    }
}
