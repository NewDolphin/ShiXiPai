package com.shixipai.api;

import android.content.Context;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.PersistentCookieStore;
import com.loopj.android.http.RequestParams;
import com.shixipai.ShiXiPaiApp;
import com.shixipai.support.PrefUtils;

/**
 * Created by xiepeng on 16/1/15.
 */
public class ApiClient {
    private static AsyncHttpClient client = new AsyncHttpClient();
    private static final PersistentCookieStore sCookieStore = new PersistentCookieStore(ShiXiPaiApp.getContext());
    public static final int DEFAULT_TIMEOUT = 20000;

    private static final String BASE_URL = "http://182.92.11.218/shixipaiAPI/";

    private static final String LOGIN_URL = "android-cli-user-aha/login";

    private static final String JOB_CLASSIFY_LIST_URL = "intern-datas/industry/";

    private static final String JOB_DETAIL_URL = "internship-datas-detail-nxmkclsiahegbxpoi/";

    private static final String INTERVIEW_TOPIC_URL = "questions/kind/";

    private static final String INTERVIEW_QUESTION_URL = "questions/topic/";

    private static final String SEARCH_URL = "intern-datas-tuijianRecommali-li";

    static {
        client.setTimeout(DEFAULT_TIMEOUT);
        client.setCookieStore(sCookieStore);
    }

    public static AsyncHttpClient getInstance() {
        return client;
    }

    public static void cancelRequest(Context context){
        client.cancelRequests(context,true);
    }

    public static void userLogin(String username, String password, JsonHttpResponseHandler handler) {
        RequestParams params = new RequestParams();
        params.put("username", username);
        params.put("password", password);

        client.post(BASE_URL + LOGIN_URL, params, handler);
    }

    public static void userLogout() {
        sCookieStore.clear();
        PrefUtils.setLogin(false);
    }

    public static void getJobItems(int page,int type,JsonHttpResponseHandler handler) {
        RequestParams params = new RequestParams();
        params.put("page", page);

        client.get(BASE_URL + JOB_CLASSIFY_LIST_URL + String.valueOf(type), params, handler);
    }

    public static void getJobDetail(int id, JsonHttpResponseHandler handler){
        client.get(BASE_URL+JOB_DETAIL_URL+String.valueOf(id),handler);
    }

    public static void getTopicItems(int page,int type,JsonHttpResponseHandler handler){
        RequestParams params = new RequestParams();
        params.put("page", page);

        client.get(BASE_URL+INTERVIEW_TOPIC_URL+String.valueOf(type+1),params,handler);
    }

    public static void getQuestionItems(int page,int type,JsonHttpResponseHandler handler){
        RequestParams params = new RequestParams();
        params.put("page", page);

        client.get(BASE_URL+INTERVIEW_QUESTION_URL+String.valueOf(type),params,handler);
    }

    public static void getSearchJobItems(Context context, int page, String cityCondition, String jobCondition, JsonHttpResponseHandler handler){
        RequestParams params = new RequestParams();
        params.put("page", page);
        params.put("city",cityCondition);
        params.put("industry", jobCondition);

        client.post(context, BASE_URL + SEARCH_URL, params, handler);
    }
}
