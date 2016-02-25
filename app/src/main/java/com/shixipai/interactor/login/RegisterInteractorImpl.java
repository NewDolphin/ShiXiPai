package com.shixipai.interactor.login;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.shixipai.api.ApiClient;
import com.shixipai.bean.User;
import com.shixipai.ui.login.register.OnRegisterCallback;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * Created by xiepeng on 16/2/25.
 */
public class RegisterInteractorImpl implements RegisterInteractor {
    @Override
    public void register(final String username, final String password, final OnRegisterCallback onRegisterCallback) {
        ApiClient.userRegister(username, password, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                try {
                    String result = response.getString("result");

                    if (result.equals("register success")) {
                        onRegisterCallback.onSuccess(new User(username, password));
                    } else if (result.equals("register failed,user exists")) {
                        onRegisterCallback.onFailure("用户名已存在");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);

            }
        });
    }
}
