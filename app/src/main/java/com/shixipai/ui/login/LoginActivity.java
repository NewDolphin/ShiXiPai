package com.shixipai.ui.login;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.shixipai.R;
import com.shixipai.support.ResourceHelper;
import com.shixipai.ui.login.login.LoginFragment;
import com.shixipai.ui.login.register.RegisterFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by xiepeng on 16/1/13.
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.layout_login_success)
    LinearLayout layout_login_success;

    @Bind(R.id.line_login)
    View line_login;

    @Bind(R.id.line_register)
    View line_register;

    @Bind(R.id.tv_login)
    TextView tv_login;

    @Bind(R.id.tv_register)
    TextView tv_register;

    @Bind(R.id.layout_login_background)
    RelativeLayout layout_login_background;

    @Bind(R.id.pb_login)
    ProgressBar progressBar;

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        //实现全屏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        layout_login_background.getBackground().setAlpha(100);

        fragmentManager = this.getSupportFragmentManager();

        showLogin();

        tv_login.setOnClickListener(this);
        tv_register.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_login:
                showLogin();
                break;
            case R.id.tv_register:
                showRegister();
                break;
        }
    }

    private void setLineGrey(){
        line_login.setBackgroundColor(ResourceHelper.getColor(R.color.color_line));
        line_register.setBackgroundColor(ResourceHelper.getColor(R.color.color_line));
    }

    private void showLogin(){
        setLineGrey();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.layout_content, new LoginFragment()).commit();
        line_login.setBackgroundColor(ResourceHelper.getColor(R.color.color_primary));
    }

    private void showRegister(){
        setLineGrey();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.layout_content, new RegisterFragment()).commit();
        line_register.setBackgroundColor(ResourceHelper.getColor(R.color.color_primary));
    }

    public void showProgressbar(){
        progressBar.setVisibility(View.VISIBLE);
    }

    public void hideProgressbar(){
        progressBar.setVisibility(View.GONE);
    }
}
