package com.shixipai.interactor.module;

import com.shixipai.interactor.JobClassifyListInteractor;
import com.shixipai.interactor.JobClassifyListInteractorImpl;
import com.shixipai.interactor.JobDetailInteractor;
import com.shixipai.interactor.JobDetailInteractorImpl;
import com.shixipai.interactor.LoginInteractor;
import com.shixipai.interactor.LoginInteractorImpl;
import com.shixipai.interactor.interview.InterviewQuestionInteractor;
import com.shixipai.interactor.interview.InterviewQuestionInteractorImpl;
import com.shixipai.interactor.interview.InterviewTopicInteractor;
import com.shixipai.interactor.interview.InterviewTopicInteractorImpl;
import com.shixipai.ui.interview.topic.InterviewTopicPresenter;
import com.shixipai.ui.interview.topic.InterviewTopicPresenterImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by xiepeng on 16/1/16.
 */
@Module(
        complete = false,
        library = true
)
public class InteractorsModule {
    @Provides
    @Singleton
    public LoginInteractor provideLoginInteractor() {
        return new LoginInteractorImpl();
    }

    @Provides
    @Singleton
    public JobClassifyListInteractor provideJobClassifyInteractor() {
        return new JobClassifyListInteractorImpl();
    }

    @Provides
    @Singleton
    public JobDetailInteractor provideJobDetailInteractor() {
        return new JobDetailInteractorImpl();
    }

    @Provides
    @Singleton
    public InterviewTopicInteractor provideInterviewTopicPresenter(){
        return new InterviewTopicInteractorImpl();
    }

    @Provides
    @Singleton
    public InterviewQuestionInteractor provideInterviewQuestionInteractor(){
        return new InterviewQuestionInteractorImpl();
    }

}
