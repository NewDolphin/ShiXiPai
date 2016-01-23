package com.shixipai.interactor.module;

import android.util.Log;

import com.shixipai.interactor.JobClassifyListInteractor;
import com.shixipai.interactor.JobClassifyListInteractorImpl;
import com.shixipai.interactor.JobInteractor;
import com.shixipai.interactor.JobInteractorImpl;
import com.shixipai.interactor.LoginInteractor;
import com.shixipai.interactor.LoginInteractorImpl;

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

    @Provides @Singleton
    public JobInteractor provideExploreInteractor() {
        return new JobInteractorImpl();
    }

    @Provides @Singleton
    public JobClassifyListInteractor provideJobClassifyInteractor() {
        return new JobClassifyListInteractorImpl();
    }

}
