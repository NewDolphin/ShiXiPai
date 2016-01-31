package com.shixipai.interactor.interview;

import com.shixipai.ui.interview.question.OnGetInterviewQuestionCallback;
import com.shixipai.ui.interview.topic.OnGetInterviewListItemCallback;

/**
 * Created by xiepeng on 16/1/31.
 */
public interface InterviewQuestionInteractor {
    void getQuestionItems(int page, int type ,OnGetInterviewQuestionCallback onGetInterviewQuestionCallback);
}
