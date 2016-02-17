package com.shixipai.interactor.resume;

import android.util.Log;

import com.google.gson.Gson;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.shixipai.api.ApiClient;
import com.shixipai.bean.edit.ResumeInfo;
import com.shixipai.ui.resume.OnGetResumeCallback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * Created by xiepeng on 16/2/17.
 */
public class ResumeInteractorImpl implements ResumeInteractor {
    @Override
    public void getResumeInfo(final OnGetResumeCallback callback) {
        ApiClient.getResumeInfo(new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                super.onSuccess(statusCode, headers, response);

                JSONObject jsonObject = new JSONObject();
                try {
                   jsonObject  = response.getJSONObject(0);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                Gson gson = new Gson();

                ResumeInfo resumeInfo = gson.fromJson(jsonObject.toString(), ResumeInfo.class);

                callback.onSuccess(resumeInfo);

            }
        });
    }
}
