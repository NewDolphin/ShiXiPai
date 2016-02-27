package com.shixipai.ui.feedback;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.shixipai.R;
import com.shixipai.bean.jobfeedback.JobFeedBack;
import com.shixipai.ui.BaseActivity;
import com.shixipai.ui.jobFeedback.list.PostedJobModule;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by xiepeng on 16/2/25.
 */
public class FeedbackActivity extends BaseActivity implements FeedbackView {
    @Inject
    FeedbackPresenter presenter;

    @Bind(R.id.toolbar_feedback)
    Toolbar toolbar;

    @Bind(R.id.et_feedback_email)
    EditText et_feedback_email;

    @Bind(R.id.et_feedback_advice)
    EditText et_feedback_advice;

    private MaterialDialog dialog;

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, FeedbackActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        ButterKnife.bind(this);

        initToolBar();

        dialog = createDialog(this).build();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_feedback, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            case R.id.action_send:
                if (et_feedback_advice.getText().toString().equals("")){
                    toastMessage("不能为空");
                    et_feedback_advice.setError("不能为空");
                }else if (et_feedback_email.getText().toString().equals("")){
                    toastMessage("不能为空");
                    et_feedback_email.setError("不能为空");
                }else if(!isEmailValid(et_feedback_email.getText().toString())){
                    toastMessage("邮箱地址不正确");
                    et_feedback_email.setError("邮箱地址不正确");
                }else {
                    presenter.sendAdvice(this,et_feedback_email.getText().toString(),
                            et_feedback_advice.getText().toString());
                    showProgress();
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initToolBar() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
    }

    @Override
    protected List<Object> getModules() {
        return Arrays.<Object>asList(new FeedbackModule(this));
    }

    @Override
    public void toastMessage(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void sendSuccess() {
        toastMessage("投递成功，感谢您的反馈");
        finish();
    }

    @Override
    public void showProgress() {
        dialog.show();
    }

    @Override
    public void hideProgress() {
        dialog.dismiss();
    }

    private MaterialDialog.Builder createDialog(final Context context){
        MaterialDialog.Builder builder = new MaterialDialog.Builder(this)
                .title("正在发送意见")
                .content("请稍等")
                .negativeText("取消")
                .onNegative(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(MaterialDialog dialog, DialogAction which) {
                        Toast.makeText(context, "cancel", Toast.LENGTH_SHORT).show();
                    }
                })
                .progress(true, 0)
                .cancelable(false)
                .progressIndeterminateStyle(false); //false表示不是horizontal

        return builder;
    }

    private boolean isEmailValid(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
