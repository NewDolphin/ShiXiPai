package com.shixipai.interactor.resume;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.shixipai.api.ApiClient;
import com.shixipai.bean.edit.ResumeInfo;
import com.shixipai.ui.edit.editinfo.want.OnGetPostResultCallback;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * Created by xiepeng on 16/2/20.
 */
public class PostResumeInteractorImpl implements PostResumeInteractor {
    @Override
    public void postResume(final ResumeInfo resumeInfo, final OnGetPostResultCallback callback) {
        ApiClient.postResumeInfo(resumeInfo, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                callback.onSuccess(true);
            }
        });

    }
}
