package com.shixipai.interactor.strategy;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.shixipai.api.ApiClient;
import com.shixipai.bean.interview.InterviewTopicItem;
import com.shixipai.bean.strategy.StrategyItem;
import com.shixipai.ui.strategy.list.OnGetStrategyItemCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

/**
 * Created by xiepeng on 16/2/6.
 */
public class StrategyInteractorImpl implements StrategyInteractor {
    @Override
    public void getStrategyItems(int page, final OnGetStrategyItemCallback onGetStrategyItemCallback) {
        ApiClient.getStrategyItem(page ,new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);

                Gson gson = new Gson();
                Type listType = new TypeToken<ArrayList<StrategyItem>>() {
                }.getType();

                ArrayList<StrategyItem> list = new ArrayList<StrategyItem>();
                try {
                    list = gson.fromJson(response.getString("data"), listType);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                onGetStrategyItemCallback.onSuccess(list);
            }
        });
    }
}
