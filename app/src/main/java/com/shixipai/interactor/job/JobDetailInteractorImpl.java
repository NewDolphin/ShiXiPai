package com.shixipai.interactor.job;

import com.google.gson.Gson;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.shixipai.api.ApiClient;
import com.shixipai.bean.JobDetail;
import com.shixipai.interactor.job.JobDetailInteractor;
import com.shixipai.ui.jobClassify.jobClassifyDetail.OnGetJobDetailCallback;
import com.shixipai.ui.jobClassify.jobClassifyDetail.OnPostJobCallback;

import org.json.JSONObject;
import cz.msebera.android.httpclient.Header;

/**
 * Created by xiepeng on 16/1/25.
 */
public class JobDetailInteractorImpl implements JobDetailInteractor {
    @Override
    public void getJobDetail(int id, final OnGetJobDetailCallback onGetJobDetailCallback) {
        ApiClient.getJobDetail(id, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);

                Gson gson = new Gson();

                JobDetail jobDetail = gson.fromJson(response.toString(),JobDetail.class);

                onGetJobDetailCallback.onSuccess(jobDetail);

            }
        });
    }

    @Override
    public void postJob(int id, final OnPostJobCallback callback) {
        ApiClient.postJob(String.valueOf(id),new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);

                callback.onPostJobSuccess(true);
            }
        });
    }
}
