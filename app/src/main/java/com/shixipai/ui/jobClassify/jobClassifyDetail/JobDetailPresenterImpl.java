package com.shixipai.ui.jobClassify.jobClassifyDetail;

import com.shixipai.bean.JobDetail;
import com.shixipai.interactor.job.JobDetailInteractor;

/**
 * Created by xiepeng on 16/1/25.
 */
public class JobDetailPresenterImpl implements JobDetailPresenter,OnGetJobDetailCallback,OnPostJobCallback {
    private JobDetailView jobDetailView;
    private JobDetailInteractor interactor;

    public JobDetailPresenterImpl(JobDetailView jobDetailView, JobDetailInteractor interactor) {
        this.jobDetailView = jobDetailView;
        this.interactor = interactor;
    }

    @Override
    public void loadData(int id) {
        interactor.getJobDetail(id,this);
    }

    @Override
    public void postJob(int id) {
        interactor.postJob(id,this);
    }


    @Override
    public void onSuccess(JobDetail jobDetail) {
        jobDetailView.addData(jobDetail);
    }

    @Override
    public void onFailed(String errorString) {

    }

    @Override
    public void onPostJobSuccess(boolean result) {
        jobDetailView.postJobSuccess(result);
    }

    @Override
    public void onPostJobFailed(String errorString) {

    }
}
