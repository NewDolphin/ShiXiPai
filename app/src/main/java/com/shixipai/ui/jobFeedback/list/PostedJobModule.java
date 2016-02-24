package com.shixipai.ui.jobFeedback.list;

import com.shixipai.interactor.jobfeedback.JobFeedbackInteractor;
import com.shixipai.interactor.search.SearchInteractor;
import com.shixipai.ui.home.HomeFragment;
import com.shixipai.ui.home.HomeListPresenter;
import com.shixipai.ui.home.HomeListPresenterImpl;
import com.shixipai.ui.home.HomeView;
import com.shixipai.ui.main.MainModule;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by xiepeng on 16/2/22.
 */
@Module(
        injects = {
                PostedJobListFragment.class
        },
        addsTo = MainModule.class,
        library = true
)

public class PostedJobModule {
    private PostedJobListView postedJobListView;

    public PostedJobModule(PostedJobListView postedJobListView){
        this.postedJobListView = postedJobListView;
    }

    @Provides
    @Singleton
    public PostedJobListView providePostedJobListView(){
        return postedJobListView;
    }

    @Provides @Singleton public PostedJobListPresenter providePostedJobListPresenter(PostedJobListView postedJobListView
            ,JobFeedbackInteractor interactor){
        return new PostedJobListPresenterImpl(postedJobListView,interactor);
    }
}
