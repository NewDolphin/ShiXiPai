package com.shixipai.ui.login.register;

import android.content.Context;
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
import com.shixipai.ui.login.login.LoginModule;
import com.shixipai.ui.login.login.LoginPresenter;
import com.shixipai.ui.main.MainActivity;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by xiepeng on 16/2/25.
 */
public class RegisterFragment extends BaseFragment implements RegisterView, View.OnClickListener {
    @Inject
    RegisterPresenter presenter;

    @Bind(R.id.et_register_username)
    EditText username;

    @Bind(R.id.et_register_password)
    EditText password;

    @Bind(R.id.et_register_password_again)
    EditText password_again;

    @Bind(R.id.bt_register)
    Button bt_register;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        ButterKnife.bind(this, view);

        bt_register.setOnClickListener(this);

        return view;
    }

    @Override
    protected List<Object> getModules() {
        return Arrays.<Object>asList(new RegisterModule(this));
    }

    @Override
    public void usernameError(String errorString) {
        username.setError(errorString);
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
        toastMessage("注册成功");
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
        if (password_again.getText().toString().equals("")){
            password_again.setError("不能为空");
            return false;
        }
        return true;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_register:
                if (!password.getText().toString().equals(password_again.getText().toString())){
                    toastMessage("两次密码不相同");
                }else {
                    if (checkEmpty()){
                        presenter.registerNewUser(username.getText().toString(),password.getText().toString());
                    }
                }
                break;
        }
    }
}
