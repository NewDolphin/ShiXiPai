package com.shixipai.ui.resume;

import com.shixipai.bean.edit.ResumeInfo;

/**
 * Created by xiepeng on 16/2/17.
 */
public interface ResumeView {
    //显示加载进度条
    void showProgress();

    //隐藏加载进度条
    void hideProgress();

    //填写数据
    void addData(ResumeInfo resumeInfo);
}
