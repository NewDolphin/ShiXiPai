package com.shixipai.api;

import android.content.Context;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.PersistentCookieStore;
import com.loopj.android.http.RequestParams;
import com.shixipai.ShiXiPaiApp;
import com.shixipai.bean.edit.ResumeInfo;
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

    private static final String STRATEGY_URL = "gl-tactics-gluebob";

    private static final String RESUME_INFO_URL = "zx-sh-jvie-kk-opwye-shh-j-jz";

    private static final String POST_RESUME_URL = "jl-ruseme-post-zxzncg-bzn";

    private static final String POST_JOB_URL = "suc-tohfoweb-bcdh-j-deliv";

    private static final String SYNC_POSTED_JOB_URL = "rsm-hdjxcie-dsjuq-de";

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

    public static void getStrategyItem(int page,JsonHttpResponseHandler handler){
        RequestParams params = new RequestParams();
        params.put("page", page);

        client.get(BASE_URL + STRATEGY_URL, params, handler);
    }

    public static void getResumeInfo(JsonHttpResponseHandler handler){
        RequestParams params = new RequestParams();
        params.put("username",PrefUtils.getPrefUsername());
        params.put("password",PrefUtils.getPrefPassword());

        client.post(BASE_URL + RESUME_INFO_URL, params, handler);
    }

    public static void postResumeInfo(ResumeInfo resumeInfo, JsonHttpResponseHandler handler){
        RequestParams params = new RequestParams();
        params.put("username",PrefUtils.getPrefUsername());
        params.put("password",PrefUtils.getPrefPassword());
        params.put("name",resumeInfo.name);
        params.put("sex",resumeInfo.sex);
        params.put("birthday",resumeInfo.birthday);
        params.put("mail",resumeInfo.mail);
        params.put("phone",resumeInfo.phone);
        params.put("school_1",resumeInfo.school_1);
        params.put("professional_1",resumeInfo.professional_1);
        params.put("grade_1",resumeInfo.grade_1);
        params.put("graduated_time_1",resumeInfo.graduated_time_1);
        params.put("school_2",resumeInfo.school_2);
        params.put("professional_2",resumeInfo.professional_2);
        params.put("grade_2",resumeInfo.grade_2);
        params.put("graduated_time_2",resumeInfo.graduated_time_2);
        params.put("school_3",resumeInfo.school_3);
        params.put("professional_3",resumeInfo.professional_3);
        params.put("grade_3",resumeInfo.grade_3);
        params.put("graduated_time_3",resumeInfo.graduated_time_3);
        params.put("want_scope",resumeInfo.want_scope);
        params.put("want_job",resumeInfo.want_job);
        params.put("want_area",resumeInfo.want_area);
        params.put("want_salary",resumeInfo.want_salary);
        params.put("add_info",resumeInfo.add_info);
        params.put("project_title_1",resumeInfo.project_title_1);
        params.put("project_start_1",resumeInfo.project_start_1);
        params.put("project_end_1",resumeInfo.project_end_1);
        params.put("project_job_1",resumeInfo.project_job_1);
        params.put("project_info_1",resumeInfo.project_info_1);
        params.put("project_title_2",resumeInfo.project_title_2);
        params.put("project_start_2",resumeInfo.project_start_2);
        params.put("project_end_2",resumeInfo.project_end_2);
        params.put("project_job_2",resumeInfo.project_job_2);
        params.put("project_info_2",resumeInfo.project_info_2);
        params.put("project_title_3",resumeInfo.project_title_3);
        params.put("project_start_3",resumeInfo.project_start_3);
        params.put("project_end_3",resumeInfo.project_end_3);
        params.put("project_job_3",resumeInfo.project_job_3);
        params.put("project_info_3",resumeInfo.project_info_3);

        client.post(BASE_URL + POST_RESUME_URL, params, handler);
    }

    public static void postJob(String jobId, JsonHttpResponseHandler handler){
        RequestParams params = new RequestParams();
        params.put("username",PrefUtils.getPrefUsername());
        params.put("iid",jobId);

        client.post(BASE_URL + POST_JOB_URL, params, handler);
    }

    public static void syncPostedJob(String username, JsonHttpResponseHandler handler){

        client.get(BASE_URL+SYNC_POSTED_JOB_URL+"/"+username,handler);

    }

}
