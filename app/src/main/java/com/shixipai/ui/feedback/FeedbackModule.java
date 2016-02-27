package com.shixipai.ui.feedback;

import com.shixipai.AppModule;
import com.shixipai.interactor.feedback.FeedbackInteractor;
import com.shixipai.interactor.job.JobDetailInteractor;
import com.shixipai.ui.jobClassify.jobClassifyDetail.JobClassifyDetailActivity;
import com.shixipai.ui.jobClassify.jobClassifyDetail.JobDetailPresenter;
import com.shixipai.ui.jobClassify.jobClassifyDetail.JobDetailPresenterImpl;
import com.shixipai.ui.jobClassify.jobClassifyDetail.JobDetailView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by xiepeng on 16/2/25.
 */
@Module(
        injects = {
                FeedbackActivity.class
        },
        addsTo = AppModule.class,
        library = true

)

public class FeedbackModule {
    private FeedbackView feedbackView;

    public FeedbackModule(FeedbackView feedbackView){
        this.feedbackView = feedbackView;
    }

    @Provides
    @Singleton
    public FeedbackView provideFeedbackView(){
        return feedbackView;
    }

    @Provides @Singleton public FeedbackPresenter provideFeedbackPresenter(FeedbackView feedbackView,
                                                                             FeedbackInteractor feedbackInteractor){
        return new FeedbackPresenterImpl(feedbackView,feedbackInteractor);
    }
}
