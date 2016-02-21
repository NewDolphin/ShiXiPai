package com.shixipai.db;

import com.shixipai.ShiXiPaiApp;
import com.shixipai.dbgenerator.PostedJob;
import com.shixipai.dbgenerator.PostedJobDao;

import java.util.Date;

import de.greenrobot.dao.query.Query;

/**
 * Created by xiepeng on 16/2/21.
 */
public class DBHelper {
    public static boolean checkJobPosted(int id){
        Query query = ShiXiPaiApp.getDaoSession().getPostedJobDao().queryBuilder()
                .where(PostedJobDao.Properties.Post_job_id.eq(id))
                .build();
        if (query.list().size() == 0){
            return false;
        }else {
            return true;
        }
    }

    public static void addPostedJob(int id){
        PostedJob postedJob = new PostedJob(null,id);
        ShiXiPaiApp.getDaoSession().getPostedJobDao().insert(postedJob);
    }

}
