package com.shixipai.ui.resume;

import com.shixipai.bean.edit.ResumeInfo;
import com.shixipai.interactor.resume.ResumeInteractor;

/**
 * Created by xiepeng on 16/2/17.
 */
public class ResumePresenterImpl implements ResumePresenter, OnGetResumeCallback {
    private ResumeView resumeView;
    private ResumeInteractor interactor;

    public ResumePresenterImpl(ResumeView resumeView, ResumeInteractor interactor) {
        this.resumeView = resumeView;
        this.interactor = interactor;
    }

    @Override
    public void loadData() {
        interactor.getResumeInfo(this);
    }

    @Override
    public void onSuccess(ResumeInfo resumeInfo) {
        resumeView.addData(resumeInfo);
    }

    @Override
    public void onFailed(String errorString) {

    }
}
