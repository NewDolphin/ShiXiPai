package com.shixipai.interactor;


import com.shixipai.ui.login.OnLoginCallback;

/**
 * Created by xiepeng.
 */
public interface LoginInteractor {

    void login(String username, String password, OnLoginCallback onLoginCallback);

}
