package com.shixipai.ui.search;

import com.shixipai.AppModule;
import com.shixipai.interactor.job.JobClassifyListInteractor;
import com.shixipai.interactor.search.SearchInteractor;
import com.shixipai.ui.jobClassify.jobClassifyList.JobClassifyListActivity;
import com.shixipai.ui.jobClassify.jobClassifyList.JobClassifyListPresenter;
import com.shixipai.ui.jobClassify.jobClassifyList.JobClassifyListPresenterImpl;
import com.shixipai.ui.jobClassify.jobClassifyList.JobClassifyListView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by xiepeng on 16/2/3.
 */
@Module(
        injects = {
                SearchActivity.class
        },
        addsTo = AppModule.class,
        library = true
)

public class SearchModule {
    private SearchView searchView;

    public SearchModule(SearchView searchView){
        this.searchView = searchView;
    }

    @Provides
    @Singleton
    public SearchView provideSearchView(){
        return searchView;
    }

    @Provides @Singleton public SearchPresenter provideSearchPresenter(SearchView searchView,
                                                                                     SearchInteractor searchInteractor){
        return new SearchPresenterImpl(searchView,searchInteractor);
    }
}