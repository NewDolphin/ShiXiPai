package com.shixipai.interactor.feedback;

import android.content.Context;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.shixipai.api.ApiClient;
import com.shixipai.ui.feedback.OnSendAdviceCallback;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * Created by xiepeng on 16/2/27.
 */
public class FeedbackInteractorImpl implements FeedbackInteractor {

    @Override
    public void sendFeedbackInfo(Context context, String email, String advice, final OnSendAdviceCallback callback) {
        ApiClient.sendFeedbackInfo(email, advice, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);

                callback.onSendAdviceSuccess(true);
            }
        });
    }

    @Override
    public void cancelRequest(Context context) {
        ApiClient.cancelRequest(context);
    }
}
