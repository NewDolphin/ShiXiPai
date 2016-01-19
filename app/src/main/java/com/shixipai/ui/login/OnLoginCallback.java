package com.shixipai.ui.login;

import com.shixipai.bean.User;

/**
 * Created by M on 2015/3/23.
 */
public interface OnLoginCallback {

    void onSuccess(User user);

    void onFailure(String errorString);

}
