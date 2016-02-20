package com.shixipai.ui.edit.editinfo.want;

import com.shixipai.AppModule;
import com.shixipai.interactor.resume.PostResumeInteractor;
import com.shixipai.interactor.resume.ResumeInteractor;
import com.shixipai.ui.resume.ResumeFragment;
import com.shixipai.ui.resume.ResumePresenter;
import com.shixipai.ui.resume.ResumePresenterImpl;
import com.shixipai.ui.resume.ResumeView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by xiepeng on 16/2/20.
 */
@Module(
        injects = {
                WantInfoFragment.class
        },
        addsTo = AppModule.class,
        library = true

)

public class PostResumeModule {
    private WantView wantView;

    public PostResumeModule(WantView wantView){
        this.wantView = wantView;
    }

    @Provides
    @Singleton
    public WantView provideWantView(){
        return wantView;
    }

    @Provides @Singleton public PostResumePresenter providePostResumePresenter(WantView wantView,
                                                                       PostResumeInteractor interactor){
        return new PostResumePresenterImpl(wantView,interactor);
    }
}
