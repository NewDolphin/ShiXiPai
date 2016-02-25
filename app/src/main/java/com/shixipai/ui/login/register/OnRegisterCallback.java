package com.shixipai.ui.login.register;

import com.shixipai.bean.User;

/**
 * Created by xiepeng on 16/2/25.
 */
public interface OnRegisterCallback {
    void onSuccess(User user);

    void onFailure(String errorString);
}
