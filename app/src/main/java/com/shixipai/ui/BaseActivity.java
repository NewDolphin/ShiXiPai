package com.shixipai.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.shixipai.ShiXiPaiApp;

import java.util.List;

import dagger.ObjectGraph;

/**
 * Created by xiepeng on 16/1/13.
 */
public abstract class BaseActivity extends AppCompatActivity {
    private ObjectGraph mActivityGraph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityGraph = ((ShiXiPaiApp) getApplication()).createScopedGraph(getModules().toArray());
        mActivityGraph.inject(this);
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        MobclickAgent.onResume(this);
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        MobclickAgent.onPause(this);
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        ApiClient.getInstance().cancelRequests(this, false);
//    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mActivityGraph = null;
    }

    //activity运行之前，注册module
    protected abstract List<Object> getModules();

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
//        StatusBarHelper.setStatusBar(this);
    }
}
