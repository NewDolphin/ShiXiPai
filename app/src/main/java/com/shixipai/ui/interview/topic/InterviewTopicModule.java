package com.shixipai.ui.interview.topic;

import com.shixipai.AppModule;
import com.shixipai.interactor.interview.InterviewTopicInteractor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by xiepeng on 16/1/30.
 */
@Module(
        injects = {
                InterviewTopicActivity.class
        },
        addsTo = AppModule.class,
        library = true
)

public class InterviewTopicModule {
    private InterviewTopicView interviewTopicView;

    public InterviewTopicModule(InterviewTopicView interviewTopicView){
        this.interviewTopicView = interviewTopicView;
    }

    @Provides
    @Singleton
    public InterviewTopicView provideInterviewTopicView(){
        return interviewTopicView;
    }

    @Provides @Singleton public InterviewTopicPresenter provideInterviewTopicPresenter(InterviewTopicView interviewTopicView,
                                                                                     InterviewTopicInteractor interviewTopicInteractor){
        return new InterviewTopicPresenterImpl(interviewTopicView,interviewTopicInteractor);
    }
}
