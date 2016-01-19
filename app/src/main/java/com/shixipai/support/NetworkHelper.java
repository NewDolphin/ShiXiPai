package com.shixipai.support;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.shixipai.ShiXiPaiApp;


/**
 * Created by xiepeng on 16/1/13.
 */
public class NetworkHelper {

    public static boolean isOnline() {
        ConnectivityManager connMgr = (ConnectivityManager)
                ShiXiPaiApp.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }
}
