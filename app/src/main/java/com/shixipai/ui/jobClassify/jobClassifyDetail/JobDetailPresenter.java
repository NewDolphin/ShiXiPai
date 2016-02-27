package com.shixipai.ui.jobClassify.jobClassifyDetail;

/**
 * Created by xiepeng on 16/1/25.
 */
public interface JobDetailPresenter {
    //加载数据
    void loadData(int id);

    void postJob(int id);

    void collectJob(int id);
}
