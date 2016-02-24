package com.shixipai.ui.home;

import com.shixipai.interactor.search.SearchInteractor;
import com.shixipai.ui.main.MainModule;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by xiepeng on 16/1/26.
 */
@Module(
        injects = {
                HomeFragment.class
        },
        addsTo = MainModule.class,
        library = true
)

public class HomeModule {
    private HomeView homeView;

    public HomeModule(HomeView homeView){
        this.homeView = homeView;
    }

    @Provides
    @Singleton
    public HomeView provideHomeView(){
        return homeView;
    }

    @Provides @Singleton public HomeListPresenter provideHomeListPresenter(HomeView homeView
            ,SearchInteractor searchInteractor){
        return new HomeListPresenterImpl(homeView,searchInteractor);
    }
}
