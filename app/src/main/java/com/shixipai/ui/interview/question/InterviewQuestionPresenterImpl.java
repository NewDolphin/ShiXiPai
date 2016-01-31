package com.shixipai.ui.interview.question;

import android.view.View;

import com.shixipai.R;
import com.shixipai.bean.interview.InterviewQuestionItem;
import com.shixipai.interactor.interview.InterviewQuestionInteractor;
import com.shixipai.support.ResourceHelper;

import java.util.ArrayList;

/**
 * Created by xiepeng on 16/1/31.
 */
public class InterviewQuestionPresenterImpl implements InterviewQuestionPresenter,OnGetInterviewQuestionCallback {
    private InterviewQuestionView interviewQuestionView;
    private InterviewQuestionInteractor interactor;

    private boolean isFirstTimeLoad = true;
    private boolean isLoadMore = false;

    private int page = 1;

    public InterviewQuestionPresenterImpl(InterviewQuestionView interviewQuestionView, InterviewQuestionInteractor interviewQuestionInteractor) {
        this.interviewQuestionView = interviewQuestionView;
        this.interactor = interviewQuestionInteractor;
    }

    @Override
    public void firstTimeLoadJobItems(int tid) {
        page = 1;
        interviewQuestionView.showFooter();
        getQuestionItems(tid);
    }

    @Override
    public void loadMoreJobItems(int tid) {
        if(isLoadMore){return;}
        page += 1;
        isLoadMore = true;
        interviewQuestionView.showFooter();
        getQuestionItems(tid);
    }

    @Override
    public void onItemClicked(View v, int position) {
        switch (v.getId()) {
            case R.id.layout_interview_question:
                interviewQuestionView.startInterviewDetailActivity(position);
                break;
        }
    }

    @Override
    public void onSuccess(ArrayList<InterviewQuestionItem> list) {
        if (list.size() > 0) {
            if(isFirstTimeLoad){
                interviewQuestionView.addListData(list);
                interviewQuestionView.hideFooter();
                isFirstTimeLoad = !isFirstTimeLoad;
                interviewQuestionView.addItemDecoration();
            }else {
                interviewQuestionView.addListData(list);
                isLoadMore = false;
            }
        } else {
            interviewQuestionView.hideFooter();
            this.interviewQuestionView.toastMessage(ResourceHelper.getString(R.string.no_more_information));
        }
        isLoadMore = false;
    }

    @Override
    public void onFailed(String errorString) {
        page -= 1;
        this.interviewQuestionView.toastMessage(errorString);
        isLoadMore = false;
    }

    private void getQuestionItems(int type) {
        this.interactor.getQuestionItems(page,type,this);
    }
}
