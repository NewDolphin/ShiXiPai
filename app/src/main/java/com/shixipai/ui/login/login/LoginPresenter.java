package com.shixipai.ui.login.login;

/**
 * Created by xiepeng on 16/1/13.
 */
public interface LoginPresenter {

    void validateLogin(String username, String password);

    void syncPostJobId(String username);
}
