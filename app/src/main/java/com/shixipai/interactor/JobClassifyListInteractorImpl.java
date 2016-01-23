package com.shixipai.interactor;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.shixipai.api.ApiClient;
import com.shixipai.bean.JobItem;
import com.shixipai.bean.JobResponse;
import com.shixipai.ui.common.OnGetJobItemsCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

/**
 * Created by xiepeng on 16/1/23.
 */
public class JobClassifyListInteractorImpl implements JobClassifyListInteractor {
    @Override
    public void getJobItems(int page, int type, final OnGetJobItemsCallback onGetJobItemsCallback) {

        ApiClient.getJobItems(page, type, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);

                Gson gson = new Gson();
                try {
                    Type listType = new TypeToken<ArrayList<JobItem>>() {}.getType();

                    JobResponse jobResponse = new JobResponse();
                    jobResponse.rows = gson.fromJson(response.getString("data"),listType);

                    Log.i("test",String.valueOf(jobResponse.rows.size()));

                    onGetJobItemsCallback.onSuccess(jobResponse);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

//                try {
//                    switch (response.getInt(ApiClient.RESP_ERROR_CODE_KEY)) {
//                        case ApiClient.SUCCESS_CODE:
//                            Gson gson = new Gson();
//                            ExploreResponse erm =
//                                    gson.fromJson(response.getJSONObject(ApiClient.RESP_MSG_KEY).toString(), ExploreResponse.class);
//                            LogHelper.v(LOG_TAG, erm.toString());
//                            onGetExploreItemsCallback.onSuccess(erm);
//                            break;
//                        case ApiClient.ERROR_CODE:
//                            onGetExploreItemsCallback.onFailed(response.getString(ApiClient.RESP_ERROR_MSG_KEY));
//                            break;
//
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }


            }
        });
    }
}
