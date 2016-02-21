package com.shixipai.ui.login;


import com.shixipai.bean.login.PostedJob;

import java.util.ArrayList;

/**
 * Created by xiepeng on 16/2/21.
 */
public interface OnSyncJobIdCallback {
    void onSyncSuccess(ArrayList<PostedJob> list);

    void onSyncFailure(String errorString);
}
