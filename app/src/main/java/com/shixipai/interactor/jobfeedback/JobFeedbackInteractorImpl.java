package com.shixipai.interactor.jobfeedback;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.shixipai.api.ApiClient;
import com.shixipai.bean.JobItem;
import com.shixipai.bean.JobResponse;
import com.shixipai.bean.jobfeedback.JobFeedBack;
import com.shixipai.ui.jobFeedback.list.OnGetJobFeedbackCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

/**
 * Created by xiepeng on 16/2/24.
 */
public class JobFeedbackInteractorImpl implements JobFeedbackInteractor {
    @Override
    public void getJobFeedbackItems(Context context, int page, final OnGetJobFeedbackCallback callback) {
        ApiClient.getJobFeedbackItems(page,new JsonHttpResponseHandler(){

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);

                Gson gson = new Gson();
                try {
                    Type listType = new TypeToken<ArrayList<JobFeedBack>>() {}.getType();

                    ArrayList<JobFeedBack> list = gson.fromJson(response.getString("data"),listType);

                    callback.onSuccess(list);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void cancelRequest(Context context) {
        ApiClient.cancelRequest(context);
    }
}
