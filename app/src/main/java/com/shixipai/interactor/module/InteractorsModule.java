package com.shixipai.interactor.module;

import android.util.Log;

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

}
