package com.shixipai.interactor.module;

import com.shixipai.interactor.job.JobClassifyListInteractor;
import com.shixipai.interactor.job.JobClassifyListInteractorImpl;
import com.shixipai.interactor.job.JobDetailInteractor;
import com.shixipai.interactor.job.JobDetailInteractorImpl;
import com.shixipai.interactor.LoginInteractor;
import com.shixipai.interactor.LoginInteractorImpl;
import com.shixipai.interactor.interview.InterviewQuestionInteractor;
import com.shixipai.interactor.interview.InterviewQuestionInteractorImpl;
import com.shixipai.interactor.interview.InterviewTopicInteractor;
import com.shixipai.interactor.interview.InterviewTopicInteractorImpl;
import com.shixipai.interactor.resume.ResumeInteractor;
import com.shixipai.interactor.resume.ResumeInteractorImpl;
import com.shixipai.interactor.search.SearchInteractor;
import com.shixipai.interactor.search.SearchIntercatorImpl;
import com.shixipai.interactor.strategy.StrategyInteractor;
import com.shixipai.interactor.strategy.StrategyInteractorImpl;

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

    @Provides
    @Singleton
    public SearchInteractor provideSearchInteractor(){
        return new SearchIntercatorImpl();
    }

    @Provides
    @Singleton
    public StrategyInteractor provideStrategyInteractor(){
        return new StrategyInteractorImpl();
    }

    @Provides
    @Singleton
    public ResumeInteractor provideResumeInteractor(){
        return new ResumeInteractorImpl();
    }
}
