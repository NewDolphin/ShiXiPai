package com.shixipai.support;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.shixipai.ShiXiPaiApp;
import com.shixipai.bean.User;

/**
 * Created by xiepeng on 16/1/13.
 */
public class PrefUtils {

    private static final String PREF_USERNAME = "username";
    private static final String PREF_PASSWORD = "password";
    private static final String PREF_IS_LOGIN = "is_login";
    private static final String PREF_CITY_CONDITION = "city_condition";
    private static final String PREF_JOB_CONDITION = "job_condition";

    public static SharedPreferences getDefaultSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(ShiXiPaiApp.getContext());
    }

    public static void setDefaultPrefUserInfo(User user) {
        getDefaultSharedPreferences().edit()
                .putString(PREF_USERNAME, user.getUsername())
                .putString(PREF_PASSWORD, user.getPassword())
                .putString(PREF_CITY_CONDITION,"全部")
                .putString(PREF_JOB_CONDITION,"全部")
                .apply();
    }

    public static String getPrefUsername() {
        return getDefaultSharedPreferences().getString(PREF_USERNAME, "not log in");
    }

    public static String getPrefPassword() {
        return getDefaultSharedPreferences().getString(PREF_PASSWORD, "not log in");
    }

    public static void setLogin(boolean isLogin) {
        getDefaultSharedPreferences().edit().putBoolean(PREF_IS_LOGIN, isLogin).apply();
    }

    public static boolean isLogin() {
        return getDefaultSharedPreferences().getBoolean(PREF_IS_LOGIN, false);
    }

    public static void setCityCondition(String city){
        getDefaultSharedPreferences().edit().putString(PREF_CITY_CONDITION, city).apply();
    }

    public static String getCityCondition(){
        return getDefaultSharedPreferences().getString(PREF_CITY_CONDITION, "全部");
    }

    public static void setJobCondition(String job){
        getDefaultSharedPreferences().edit().putString(PREF_JOB_CONDITION,job).apply();
    }

    public static String getJobCondition(){
        return getDefaultSharedPreferences().getString(PREF_JOB_CONDITION,"全部");
    }
}
