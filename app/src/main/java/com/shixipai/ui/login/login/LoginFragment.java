package com.shixipai.ui.login.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.shixipai.R;
import com.shixipai.ui.BaseFragment;
import com.shixipai.ui.login.LoginActivity;
import com.shixipai.ui.main.MainActivity;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by xiepeng on 16/2/24.
 */
public class LoginFragment extends BaseFragment implements LoginView,View.OnClickListener {
    @Inject
    LoginPresenter mLoginPresenter;

    @Bind(R.id.et_login_username)
    EditText username;
    @Bind(R.id.et_login_password)
    EditText password;
    @Bind(R.id.bt_login)
    Button bt_login;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        ButterKnife.bind(this, view);

        bt_login.setOnClickListener(this);

        return view;
    }

    @Override
    protected List<Object> getModules() {
        return Arrays.<Object>asList(new LoginModule(this));
    }

    @Override
    public void usernameError(String errorString) {
        username.setError(errorString);
    }

    @Override
    public void passwordError(String errorString) {
        password.setError(errorString);
    }

    @Override
    public void showProgressBar() {
        LoginActivity loginActivity = (LoginActivity)getActivity();
        loginActivity.showProgressbar();
    }

    @Override
    public void hideProgressBar() {
        LoginActivity loginActivity = (LoginActivity)getActivity();
        loginActivity.hideProgressbar();
    }

    @Override
    public void hideKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager)getActivity().getApplicationContext().
                getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(password.getWindowToken(), 0);
    }

    @Override
    public void toastMessage(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void startMainActivity() {
        MainActivity.actionStart(getActivity());
        getActivity().finish();
        toastMessage("登陆成功");
    }

    @Override
    public boolean checkEmpty() {
        if (username.getText().toString().equals("")){
            username.setError("不能为空");
            return false;
        }
        if (password.getText().toString().equals("")){
            password.setError("不能为空");
            return false;
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_login:
                if (checkEmpty()){
                    mLoginPresenter.validateLogin(username.getText().toString(), password.getText().toString());
                }
                break;
        }
    }

}
