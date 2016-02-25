package com.shixipai.interactor.login;


import com.shixipai.ui.login.login.OnLoginCallback;
import com.shixipai.ui.login.login.OnSyncJobIdCallback;

/**
 * Created by xiepeng.
 */
public interface LoginInteractor {

    void login(String username, String password, OnLoginCallback onLoginCallback);

    void syncJobId(String username, OnSyncJobIdCallback callback);

}
