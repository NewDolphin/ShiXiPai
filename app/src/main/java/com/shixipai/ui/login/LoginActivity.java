package com.shixipai.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.shixipai.R;
import com.shixipai.bean.User;
import com.shixipai.support.PrefUtils;
import com.shixipai.ui.BaseActivity;
import com.shixipai.ui.main.MainActivity;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by xiepeng on 16/1/13.
 */
public class LoginActivity extends BaseActivity implements LoginView,View.OnClickListener{

    @Inject
    LoginPresenter mLoginPresenter;

 //   @Bind(R.id.username)
    EditText username;
  //  @Bind(R.id.password)
    EditText password;
    @Bind(R.id.bt_login)
    Button bt_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        bt_login.setOnClickListener(this);
    }

    @Override
    protected List<Object> getModules() {
        return Arrays.<Object>asList(new LoginModule(this));
    }

    @Override
    public void usernameError(String errorString) {

    }

    @Override
    public void passwordError(String errorString) {

    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }

    @Override
    public void hideKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getApplicationContext().
                getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(password.getWindowToken(), 0);
    }

    @Override
    public void toastMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void startMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        this.finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_login:
                mLoginPresenter.validateLogin(username.getText().toString(), password.getText().toString());
                break;
        }
    }
}
