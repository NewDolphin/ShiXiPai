package com.shixipai.ui.login.login;

/**
 * Created by xiepeng on 16/1/13.
 */
public interface LoginView {

    void usernameError(String errorString);

    void passwordError(String errorString);

    void showProgressBar();

    void hideProgressBar();

    void hideKeyboard();

    void toastMessage(String msg);

    void startMainActivity();

    boolean checkEmpty();
}
