package com.shixipai.ui.edit.editinfo.want;


/**
 * Created by xiepeng on 16/2/20.
 */
public interface OnGetPostResultCallback {
    void onSuccess(boolean result);

    void onFailed(String errorString);
}
