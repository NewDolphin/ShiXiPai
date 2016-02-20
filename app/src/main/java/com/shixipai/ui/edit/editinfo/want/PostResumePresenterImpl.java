package com.shixipai.ui.edit.editinfo.want;

import android.util.Log;

import com.shixipai.bean.edit.ResumeInfo;
import com.shixipai.interactor.resume.PostResumeInteractor;

/**
 * Created by xiepeng on 16/2/20.
 */
public class PostResumePresenterImpl implements PostResumePresenter, OnGetPostResultCallback {
    private WantView wantView;
    private PostResumeInteractor interactor;

    public PostResumePresenterImpl(WantView wantView, PostResumeInteractor interactor) {
        this.wantView = wantView;
        this.interactor = interactor;
    }

    @Override
    public void postResume(ResumeInfo resumeInfo) {
        interactor.postResume(resumeInfo,this);
    }

    @Override
    public void onSuccess(boolean result) {
        wantView.postResult(true);
    }

    @Override
    public void onFailed(String errorString) {

    }
}
