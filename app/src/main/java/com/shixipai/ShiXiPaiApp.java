package com.shixipai;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.shixipai.dbgenerator.DaoMaster;
import com.shixipai.dbgenerator.DaoSession;

import java.util.Arrays;
import java.util.List;

import dagger.ObjectGraph;

/**
 * Created by xiepeng on 16/1/13.
 */
public class ShiXiPaiApp extends Application {
    private static Context sContext;

    private ObjectGraph objectGraph;

    //数据库相关变量
    private SQLiteDatabase db;
    private DaoMaster daoMaster;
    private static DaoSession daoSession;


    @Override
    public void onCreate() {
        super.onCreate();

        objectGraph = ObjectGraph.create(getModules().toArray());
        objectGraph.inject(this);

        sContext = getApplicationContext();

        //数据库相关
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "shixipai-db", null);
        db = helper.getWritableDatabase();
        // 注意：该数据库连接属于 DaoMaster，所以多个 Session 指的是相同的数据库连接。
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    public static Context getContext() {
        return sContext;
    }

    private List<Object> getModules() {
        return Arrays.<Object>asList(new AppModule(this));
    }

    public ObjectGraph createScopedGraph(Object... modules) {
        return objectGraph.plus(modules);
    }

    //数据库相关
    public static DaoSession getDaoSession(){
        return daoSession;
    }
}
