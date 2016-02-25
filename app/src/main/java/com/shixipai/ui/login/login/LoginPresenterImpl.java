package com.shixipai.ui.login.login;

import android.text.TextUtils;

import com.shixipai.R;
import com.shixipai.ShiXiPaiApp;
import com.shixipai.bean.User;
import com.shixipai.bean.login.PostedJob;
import com.shixipai.interactor.login.LoginInteractor;
import com.shixipai.support.NetworkHelper;
import com.shixipai.support.PrefUtils;
import com.shixipai.support.ResourceHelper;

import java.util.ArrayList;


/**
 * Created by xiepeng on 16/1/13.
 */
public class LoginPresenterImpl implements LoginPresenter, OnLoginCallback, OnSyncJobIdCallback {
    private LoginView mLoginView;
    private LoginInteractor mLoginInteractor;

    public LoginPresenterImpl(LoginView loginView, LoginInteractor loginInteractor) {
        this.mLoginView = loginView;
        this.mLoginInteractor = loginInteractor;
    }

    @Override
    public void validateLogin(String username, String password) {

        mLoginView.hideKeyboard();
        if (!NetworkHelper.isOnline()) {
            mLoginView.toastMessage(ResourceHelper.getString(R.string.network_not_connected));
            return;
        }
        mLoginView.showProgressBar();
        if (TextUtils.isEmpty(username)) {
            mLoginView.usernameError(ResourceHelper.getString(R.string.login_error_empty));
            mLoginView.hideProgressBar();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            mLoginView.passwordError(ResourceHelper.getString(R.string.login_error_empty));
            mLoginView.hideProgressBar();
            return;
        }

        mLoginInteractor.login(username, password, this);
    }

    @Override
    public void syncPostJobId(String username) {
        mLoginInteractor.syncJobId(PrefUtils.getPrefUsername(),this);
    }

    //验证登陆正确回调函数
    @Override
    public void onSuccess(User user) {
        PrefUtils.setDefaultPrefUserInfo(user);
        PrefUtils.setLogin(true);

//        JPushHelper jPushHelper = new JPushHelper(String.valueOf(userInfo.uid),null);
//        jPushHelper.setAlias();

        //正确登陆后，同步已投递职位
        syncPostJobId(PrefUtils.getPrefUsername());
    }

    @Override
    public void onFailure(String errorString) {
        mLoginView.hideProgressBar();
        mLoginView.toastMessage(errorString);
        if (errorString.equals("用户名不存在")){
            mLoginView.usernameError(errorString);
        }else {
            mLoginView.passwordError(errorString);
        }
    }

    //同步已投递职位回调函数
    @Override
    public void onSyncSuccess(ArrayList<PostedJob> list) {
        for (PostedJob postedJob : list){
            com.shixipai.dbgenerator.PostedJob job = new com.shixipai.dbgenerator
                    .PostedJob(null,postedJob.getIid());
            ShiXiPaiApp.getDaoSession().getPostedJobDao().insert(job);
        }

        mLoginView.hideProgressBar();
        mLoginView.startMainActivity();
    }

    @Override
    public void onSyncFailure(String errorString) {

    }
}
