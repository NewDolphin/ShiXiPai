package com.shixipai.ui.jobClassify.jobClassifyList;

import com.shixipai.AppModule;
import com.shixipai.interactor.job.JobClassifyListInteractor;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by xiepeng on 16/1/23.
 */
@Module(
        injects = {
                JobClassifyListActivity.class
        },
        addsTo = AppModule.class,
        library = true
)

public class JobClassifyListModule {
    private JobClassifyListView jobClassifyListView;

    public JobClassifyListModule(JobClassifyListView jobClassifyListView){
        this.jobClassifyListView = jobClassifyListView;
    }

    @Provides
    @Singleton
    public JobClassifyListView provideJobClassifyListView(){
        return jobClassifyListView;
    }

    @Provides @Singleton public JobClassifyListPresenter provideJobClassifyPresenter(JobClassifyListView jobClassifyListView,
                                                                             JobClassifyListInteractor jobClassifyListInteractor){
        return new JobClassifyListPresenterImpl(jobClassifyListView,jobClassifyListInteractor);
    }
}
