package com.shixipai.interactor.interview;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.shixipai.api.ApiClient;
import com.shixipai.bean.interview.InterviewTopicItem;
import com.shixipai.ui.interview.topic.OnGetInterviewListItemCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

/**
 * Created by xiepeng on 16/1/30.
 */
public class InterviewTopicInteractorImpl implements InterviewTopicInteractor {
    @Override
    public void getJobItems(int page, int type, final OnGetInterviewListItemCallback onGetInterviewListItemCallback) {
        ApiClient.getTopicItems(page, type, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);

                Gson gson = new Gson();
                Type listType = new TypeToken<ArrayList<InterviewTopicItem>>() {
                }.getType();

                ArrayList<InterviewTopicItem> list = new ArrayList<InterviewTopicItem>();
                try {
                    list = gson.fromJson(response.getString("data"), listType);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                onGetInterviewListItemCallback.onSuccess(list);
            }
        });
    }
}
