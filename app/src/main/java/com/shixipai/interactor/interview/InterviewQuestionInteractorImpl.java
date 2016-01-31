package com.shixipai.interactor.interview;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.shixipai.api.ApiClient;
import com.shixipai.bean.interview.InterviewQuestionItem;
import com.shixipai.bean.interview.InterviewTopicItem;
import com.shixipai.ui.interview.question.OnGetInterviewQuestionCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

/**
 * Created by xiepeng on 16/1/31.
 */
public class InterviewQuestionInteractorImpl implements InterviewQuestionInteractor {
    @Override
    public void getQuestionItems(int page, int type, final OnGetInterviewQuestionCallback onGetInterviewQuestionCallback) {
        ApiClient.getQuestionItems(page, type, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);

                Gson gson = new Gson();
                Type listType = new TypeToken<ArrayList<InterviewQuestionItem>>() {
                }.getType();

                ArrayList<InterviewQuestionItem> list = new ArrayList<InterviewQuestionItem>();
                try {
                    list = gson.fromJson(response.getString("data"), listType);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                onGetInterviewQuestionCallback.onSuccess(list);
            }
        });
    }
}
