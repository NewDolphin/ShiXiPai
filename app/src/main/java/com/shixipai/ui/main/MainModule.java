package com.shixipai.ui.main;

import com.shixipai.AppModule;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by xiepeng on 16/1/19.
 */
@Module(
        injects = MainActivity.class,
        addsTo = AppModule.class
)
public class MainModule {

    private MainView mMainView;

    public MainModule(MainView mainView) {
        this.mMainView = mainView;
    }

    @Provides
    @Singleton
    public MainView provideMainView() {
        return mMainView;
    }

    @Provides
    @Singleton
    public MainPresenter provideMainPresenter(MainView mainView) {
        return new MainPresenterImpl(mainView);
    }
}
