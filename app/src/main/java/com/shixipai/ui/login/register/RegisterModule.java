package com.shixipai.ui.login.register;

import com.shixipai.AppModule;
import com.shixipai.interactor.login.LoginInteractor;
import com.shixipai.interactor.login.RegisterInteractor;
import com.shixipai.ui.login.login.LoginFragment;
import com.shixipai.ui.login.login.LoginPresenter;
import com.shixipai.ui.login.login.LoginPresenterImpl;
import com.shixipai.ui.login.login.LoginView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by xiepeng on 16/2/25.
 */
@Module(
        injects = RegisterFragment.class,
        addsTo = AppModule.class
)
public class RegisterModule {

    private RegisterView registerView;

    public RegisterModule(RegisterView registerView) {
        this.registerView = registerView;
    }

    @Provides
    @Singleton
    public RegisterView provideRegisterView() {
        return registerView;
    }

    @Provides
    @Singleton
    public RegisterPresenter provideRegisterPresenter(RegisterView registerView, RegisterInteractor registerInteractor) {
        return new RegisterPresenterImpl(registerView, registerInteractor);
    }
}
