package com.shixipai.ui.interview.question;

import com.shixipai.AppModule;
import com.shixipai.interactor.interview.InterviewQuestionInteractor;
import com.shixipai.interactor.interview.InterviewTopicInteractor;
import com.shixipai.ui.interview.topic.InterviewTopicActivity;
import com.shixipai.ui.interview.topic.InterviewTopicPresenter;
import com.shixipai.ui.interview.topic.InterviewTopicPresenterImpl;
import com.shixipai.ui.interview.topic.InterviewTopicView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by xiepeng on 16/1/31.
 */
@Module(
        injects = {
                InterviewQuestionActivity.class
        },
        addsTo = AppModule.class,
        library = true
)

public class InterviewQuestionModule {
    private InterviewQuestionView interviewQuestionView;

    public InterviewQuestionModule(InterviewQuestionView interviewQuestionView){
        this.interviewQuestionView = interviewQuestionView;
    }

    @Provides
    @Singleton
    public InterviewQuestionView provideInterviewQuestionView(){
        return interviewQuestionView;
    }

    @Provides @Singleton public InterviewQuestionPresenter provideInterviewQuestionPresenter(InterviewQuestionView interviewQuestionView,
                                                                                       InterviewQuestionInteractor interviewQuestionInteractor){
        return new InterviewQuestionPresenterImpl(interviewQuestionView,interviewQuestionInteractor);
    }
}
