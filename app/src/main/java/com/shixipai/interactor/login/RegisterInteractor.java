package com.shixipai.interactor.login;

import com.shixipai.ui.login.register.OnRegisterCallback;

/**
 * Created by xiepeng on 16/2/25.
 */
public interface RegisterInteractor {
    void register(String username, String password, OnRegisterCallback onRegisterCallback);
}
