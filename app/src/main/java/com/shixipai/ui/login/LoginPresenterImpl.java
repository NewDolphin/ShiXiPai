package com.shixipai.ui.login;

import android.text.TextUtils;
import android.util.Log;

import com.shixipai.R;
import com.shixipai.bean.User;
import com.shixipai.interactor.LoginInteractor;
import com.shixipai.support.NetworkHelper;
import com.shixipai.support.PrefUtils;
import com.shixipai.support.ResourceHelper;


/**
 * Created by xiepeng on 16/1/13.
 */
public class LoginPresenterImpl implements LoginPresenter, OnLoginCallback {

    private LoginView mLoginView;
    private LoginInteractor mLoginInteractor;

    public LoginPresenterImpl(LoginView loginView, LoginInteractor loginInteractor) {
        this.mLoginView = loginView;
        this.mLoginInteractor = loginInteractor;
    }

    @Override
    public void validateLogin(String username, String password) {

        mLoginView.hideKeyboard();
        if (!NetworkHelper.isOnline()) {
            mLoginView.toastMessage(ResourceHelper.getString(R.string.network_not_connected));
            return;
        }
        mLoginView.showProgressBar();
        if (TextUtils.isEmpty(username)) {
            mLoginView.usernameError(ResourceHelper.getString(R.string.login_error_empty));
            mLoginView.hideProgressBar();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            mLoginView.passwordError(ResourceHelper.getString(R.string.login_error_empty));
            mLoginView.hideProgressBar();
            return;
        }

        mLoginInteractor.login(username, password, this);
    }

    @Override
    public void onSuccess(User user) {
        PrefUtils.setDefaultPrefUserInfo(user);
        PrefUtils.setLogin(true);

        Log.i("test", "onSuccess");

//        JPushHelper jPushHelper = new JPushHelper(String.valueOf(userInfo.uid),null);
//        jPushHelper.setAlias();

        mLoginView.hideProgressBar();
        mLoginView.startMainActivity();
    }

    @Override
    public void onFailure(String errorString) {
        mLoginView.hideProgressBar();
        mLoginView.toastMessage(errorString);
    }
}
