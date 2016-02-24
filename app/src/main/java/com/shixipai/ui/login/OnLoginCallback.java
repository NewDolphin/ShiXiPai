package com.shixipai.ui.login;

import com.shixipai.bean.User;

/**
 * Created by xiepeng on 16/1/13.
 */
public interface OnLoginCallback {

    void onSuccess(User user);

    void onFailure(String errorString);

}
