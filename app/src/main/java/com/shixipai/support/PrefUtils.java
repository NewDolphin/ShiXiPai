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

    public static SharedPreferences getDefaultSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(ShiXiPaiApp.getContext());
    }

    public static void setDefaultPrefUserInfo(User user) {
        getDefaultSharedPreferences().edit()
                .putString(PREF_USERNAME, user.getUsername())
                .putString(PREF_PASSWORD, user.getPassword())
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
}
