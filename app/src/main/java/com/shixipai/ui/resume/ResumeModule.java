package com.shixipai.ui.resume;

import com.shixipai.AppModule;
import com.shixipai.interactor.resume.ResumeInteractor;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

/**
 * Created by xiepeng on 16/2/17.
 */
@Module(
        injects = {
                ResumeFragment.class
        },
        addsTo = AppModule.class,
        library = true

)

public class ResumeModule {
    private ResumeView resumeView;

    public ResumeModule(ResumeView resumeView){
        this.resumeView = resumeView;
    }

    @Provides
    @Singleton
    public ResumeView provideResumeView(){
        return resumeView;
    }

    @Provides @Singleton public ResumePresenter provideResumePresenter(ResumeView resumeView,
                                                                             ResumeInteractor resumeInteractor){
        return new ResumePresenterImpl(resumeView,resumeInteractor);
    }
}
