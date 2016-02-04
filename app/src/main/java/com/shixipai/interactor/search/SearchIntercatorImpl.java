package com.shixipai.interactor.search;

import android.util.Log;

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
 * Created by xiepeng on 16/2/3.
 */
public class SearchIntercatorImpl implements SearchInteractor {
    @Override
    public void getJobItems(int page, String cityCondition, String jobCondition, final OnGetJobItemsCallback onGetJobItemsCallback) {
        ApiClient.getSearchJobItems(page, cityCondition, jobCondition, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);

                Gson gson = new Gson();
                try {
                    Type listType = new TypeToken<ArrayList<JobItem>>() {
                    }.getType();

                    JobResponse jobResponse = new JobResponse();
                    jobResponse.rows = gson.fromJson(response.getString("data"), listType);

                    Log.i("test", String.valueOf(jobResponse.rows.size()));

                    onGetJobItemsCallback.onSuccess(jobResponse);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
