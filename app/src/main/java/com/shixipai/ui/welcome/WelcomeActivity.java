package com.shixipai.ui.welcome;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import com.shixipai.R;
import com.shixipai.support.PrefUtils;
import com.shixipai.ui.login.LoginActivity;
import com.shixipai.ui.main.MainActivity;

/**
 * Created by xiepeng on 16/1/13.
 */
public class WelcomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //截图图片周围失真
        getWindow().setFormat(PixelFormat.RGBA_8888);
        //实现全屏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_welcome);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent;
                if (PrefUtils.isLogin()) {
                    intent = new Intent(WelcomeActivity.this, MainActivity.class);
                } else {
                    intent = new Intent(WelcomeActivity.this, LoginActivity.class);
                }
                WelcomeActivity.this.startActivity(intent);
                WelcomeActivity.this.finish();
            }
        }, 2000);

    }
}
