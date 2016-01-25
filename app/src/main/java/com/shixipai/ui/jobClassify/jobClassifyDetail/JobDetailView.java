package com.shixipai.ui.jobClassify.jobClassifyDetail;

import com.shixipai.bean.JobDetail;

/**
 * Created by xiepeng on 16/1/25.
 */
public interface JobDetailView {
    //显示加载进度条
    void showProgress();

    //隐藏加载进度条
    void hideProgress();

    //填写数据
    void addData(JobDetail jobDetail);

}
