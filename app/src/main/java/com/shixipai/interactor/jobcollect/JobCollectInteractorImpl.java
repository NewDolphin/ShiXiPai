package com.shixipai.interactor.jobcollect;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.shixipai.api.ApiClient;
import com.shixipai.bean.JobItem;
import com.shixipai.bean.JobResponse;
import com.shixipai.ui.common.job.OnGetJobItemsCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

/**
 * Created by xiepeng on 16/2/26.
 */
public class JobCollectInteractorImpl implements JobCollectInteractor{
    @Override
    public void getJobItems(Context context, int page, final OnGetJobItemsCallback onGetJobItemsCallback) {
        ApiClient.getCollectedJob(context, page, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);

                Gson gson = new Gson();
                try {
                    Type listType = new TypeToken<ArrayList<JobItem>>() {
                    }.getType();

                    JobResponse jobResponse = new JobResponse();
                    jobResponse.rows = gson.fromJson(response.getString("data"), listType);

                    onGetJobItemsCallback.onSuccess(jobResponse);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void cancelRequest(Context context) {

    }
}
