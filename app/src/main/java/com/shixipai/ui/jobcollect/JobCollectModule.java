package com.shixipai.ui.jobcollect;

import com.shixipai.AppModule;
import com.shixipai.interactor.job.JobClassifyListInteractor;
import com.shixipai.interactor.jobcollect.JobCollectInteractor;
import com.shixipai.ui.jobClassify.jobClassifyList.JobClassifyListActivity;
import com.shixipai.ui.jobClassify.jobClassifyList.JobClassifyListPresenter;
import com.shixipai.ui.jobClassify.jobClassifyList.JobClassifyListPresenterImpl;
import com.shixipai.ui.jobClassify.jobClassifyList.JobClassifyListView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by xiepeng on 16/2/26.
 */
@Module(
        injects = {
                JobCollectActivity.class
        },
        addsTo = AppModule.class,
        library = true
)

public class JobCollectModule {
    private JobCollectView jobCollectView;

    public JobCollectModule(JobCollectView jobCollectView){
        this.jobCollectView = jobCollectView;
    }

    @Provides
    @Singleton
    public JobCollectView provideJobCollectView(){
        return jobCollectView;
    }

    @Provides @Singleton public JobCollectPresenter provideJobCollectPresenter(JobCollectView jobCollectView,
                                                                                     JobCollectInteractor jobCollectInteractor){
        return new JobCollectPresenterImpl(jobCollectView,jobCollectInteractor);
    }
}
