package com.shixipai.ui.strategy.list;

import com.shixipai.AppModule;
import com.shixipai.interactor.interview.InterviewTopicInteractor;
import com.shixipai.interactor.strategy.StrategyInteractor;
import com.shixipai.ui.interview.topic.InterviewTopicActivity;
import com.shixipai.ui.interview.topic.InterviewTopicPresenter;
import com.shixipai.ui.interview.topic.InterviewTopicPresenterImpl;
import com.shixipai.ui.interview.topic.InterviewTopicView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by xiepeng on 16/2/6.
 */
@Module(
        injects = {
                StrategyListActivity.class
        },
        addsTo = AppModule.class,
        library = true
)

public class StrategyListModule {
    private StrategyListView strategyListView;

    public StrategyListModule(StrategyListView strategyListView){
        this.strategyListView = strategyListView;
    }

    @Provides
    @Singleton
    public StrategyListView provideStrategyListView(){
        return strategyListView;
    }

    @Provides @Singleton public StrategyListPresenter provideStrategyListPresenter(StrategyListView strategyListView,
                                                                                       StrategyInteractor strategyInteractor){
        return new StrategyListPresenterImpl(strategyListView,strategyInteractor);
    }
}
