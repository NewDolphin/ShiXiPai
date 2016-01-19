package com.shixipai.ui.login;



import com.shixipai.AppModule;
import com.shixipai.interactor.LoginInteractor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by xiepeng on 16/1/13.
 */
@Module(
        injects = LoginActivity.class,
        addsTo = AppModule.class
)
public class LoginModule {

    private LoginView mLoginView;

    public LoginModule(LoginView loginView) {
        this.mLoginView = loginView;
    }

    @Provides
    @Singleton
    public LoginView provideLoginView() {
        return mLoginView;
    }

    @Provides
    @Singleton
    public LoginPresenter provideLoginPresenter(LoginView loginView, LoginInteractor loginInteractor) {
        return new LoginPresenterImpl(loginView, loginInteractor);
    }
}
