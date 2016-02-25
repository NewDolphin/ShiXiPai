package com.shixipai.ui.login.register;

/**
 * Created by xiepeng on 16/2/25.
 */
public interface RegisterView {
    void usernameError(String errorString);

    void showProgressBar();

    void hideProgressBar();

    void hideKeyboard();

    void toastMessage(String msg);

    void startMainActivity();
}
