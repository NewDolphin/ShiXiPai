package com.shixipai.ui.interview.topic;

import android.view.View;

import com.shixipai.R;
import com.shixipai.bean.interview.InterviewTopicItem;
import com.shixipai.interactor.interview.InterviewTopicInteractor;
import com.shixipai.support.ResourceHelper;
import com.shixipai.ui.interview.question.InterviewQuestionActivity;

import java.util.ArrayList;


/**
 * Created by xiepeng on 16/1/30.
 */
public class InterviewTopicPresenterImpl implements InterviewTopicPresenter, OnGetInterviewListItemCallback{
    private InterviewTopicView interviewTopicView;
    private InterviewTopicInteractor interactor;

    private boolean isFirstTimeLoad = true;
    private boolean isLoadMore = false;

    private int page = 1;

    public InterviewTopicPresenterImpl(InterviewTopicView interviewTopicView, InterviewTopicInteractor interviewTopicInteractor) {
        this.interviewTopicView = interviewTopicView;
        this.interactor = interviewTopicInteractor;
    }
    @Override
    public void firstTimeLoadJobItems(int id) {
        page = 1;
        interviewTopicView.showFooter();
        getTopicItems(id);
    }

    @Override
    public void loadMoreJobItems(int id) {
        if(isLoadMore){return;}
        page += 1;
        isLoadMore = true;
        interviewTopicView.showFooter();
        getTopicItems(id);
    }

    @Override
    public void onItemClicked(View v, int position) {
        switch (v.getId()) {
            case R.id.layout_interview_topic:
                interviewTopicView.startInterviewQuestionActivity(position);
                break;
        }
    }

    private void getTopicItems(int type) {
        this.interactor.getJobItems(page,type, this);
    }

    @Override
    public void onSuccess(ArrayList<InterviewTopicItem> list) {
        if (list.size() > 0) {
            if(isFirstTimeLoad){
                interviewTopicView.addListData(list);
                interviewTopicView.hideFooter();
                isFirstTimeLoad = !isFirstTimeLoad;
            }else {
                interviewTopicView.addListData(list);
                isLoadMore = false;
            }
        } else {
            interviewTopicView.hideFooter();
            this.interviewTopicView.toastMessage(ResourceHelper.getString(R.string.no_more_information));
        }
        isLoadMore = false;
    }

    @Override
    public void onFailed(String errorString) {
        page -= 1;
        this.interviewTopicView.toastMessage(errorString);
        isLoadMore = false;
    }
}
