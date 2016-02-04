package com.shixipai.ui.jobClassify.jobClassifyDetail;

import com.shixipai.AppModule;
import com.shixipai.interactor.job.JobDetailInteractor;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by xiepeng on 16/1/25.
 */
@Module(
        injects = {
                JobClassifyDetailActivity.class
        },
        addsTo = AppModule.class,
        library = true

)

public class JobDetailModule {
    private JobDetailView jobDetailView;

    public JobDetailModule(JobDetailView jobDetailView){
        this.jobDetailView = jobDetailView;
    }

    @Provides
    @Singleton
    public JobDetailView provideJobDetailView(){
        return jobDetailView;
    }

    @Provides @Singleton public JobDetailPresenter provideJobDetailPresenter(JobDetailView jobDetailView,
                                                                             JobDetailInteractor jobDetailInteractor){
        return new JobDetailPresenterImpl(jobDetailView,jobDetailInteractor);
    }
}
