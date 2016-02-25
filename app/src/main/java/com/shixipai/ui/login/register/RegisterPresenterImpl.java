package com.shixipai.ui.login.register;

import com.shixipai.bean.User;
import com.shixipai.interactor.login.RegisterInteractor;
import com.shixipai.support.PrefUtils;

/**
 * Created by xiepeng on 16/2/25.
 */
public class RegisterPresenterImpl implements RegisterPresenter, OnRegisterCallback {
    private RegisterView registerView;
    private RegisterInteractor interactor;

    public RegisterPresenterImpl(RegisterView registerView, RegisterInteractor registerInteractor) {
        this.registerView = registerView;
        this.interactor = registerInteractor;
    }

    @Override
    public void registerNewUser(String username, String password) {
        interactor.register(username,password,this);
    }

    @Override
    public void onSuccess(User user) {
        PrefUtils.setDefaultPrefUserInfo(user);
        PrefUtils.setLogin(true);

        registerView.hideProgressBar();
        registerView.startMainActivity();
    }

    @Override
    public void onFailure(String errorString) {
        registerView.hideProgressBar();
        registerView.toastMessage(errorString);
    }
}
