package com.shixipai.ui.job.list;

import com.shixipai.interactor.JobInteractor;
import com.shixipai.ui.main.MainModule;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

/**
 * Created by xiepeng on 16/1/19.
 */
@Module(
        injects = {
                JobListFragment.class
        },
        addsTo = MainModule.class,
        library = true

)

public class JobListModule {
    private JobListView jobListView;

    public JobListModule(JobListView jobListView){
        this.jobListView = jobListView;
    }

    @Provides @Singleton public JobListView provideJobListView(){
        return jobListView;
    }

    @Provides @Singleton public JobListPresenter provideJobPresenter(JobListView jobListView,JobInteractor jobInteractor){
        return new JobListPresenterImpl(jobListView,jobInteractor);
    }
}
