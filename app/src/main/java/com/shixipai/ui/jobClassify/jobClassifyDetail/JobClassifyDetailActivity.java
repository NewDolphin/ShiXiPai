package com.shixipai.ui.jobClassify.jobClassifyDetail;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.shixipai.R;
import com.shixipai.bean.JobDetail;
import com.shixipai.bean.edit.ResumeInfo;
import com.shixipai.db.DBHelper;
import com.shixipai.support.ResourceHelper;
import com.shixipai.ui.BaseActivity;
import com.shixipai.ui.jobClassify.jobClassifyList.JobClassifyListModule;
import com.squareup.picasso.Picasso;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * Created by xiepeng on 16/1/23.
 */
public class JobClassifyDetailActivity extends BaseActivity implements JobDetailView, View.OnClickListener{
    @Inject
    JobDetailPresenter presenter;

    @Bind(R.id.job_detail_toolbar)
    Toolbar toolbar;

    @Bind(R.id.img_job_classify_detail)
    ImageView img_company;

    @Bind(R.id.tv_job_detail_title)
    TextView tv_job_title;

    @Bind(R.id.tv_job_detail_company)
    TextView tv_job_company;

    @Bind(R.id.tv_job_detail_area)
    TextView tv_job_area;

    @Bind(R.id.tv_job_detail_salary)
    TextView tv_job_salary;

    @Bind(R.id.tv_job_detail_edu)
    TextView tv_job_edu;

    @Bind(R.id.tv_job_detail_html)
    TextView tv_job_html;

    @Bind(R.id.pb_job_detail)
    ProgressBar progressBar;

    @Bind(R.id.sv_job_detail)
    ScrollView sv_content;

    @Bind(R.id.layout_job_detail_send)
    LinearLayout layout_send;

    @Bind(R.id.bt_job_detail_collect)
    Button bt_collect;

    @Bind(R.id.bt_job_detail_post)
    Button bt_post;

    int jobId;

    String jobTitle;

    private MaterialDialog dialog;

    private static final String PARAM_ID = "id";

    public static void actionStart(Context context,int id) {
        Intent intent = new Intent(context, JobClassifyDetailActivity.class);
        intent.putExtra(PARAM_ID,id);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_classify_detail);

        ButterKnife.bind(this);

        initToolBar();

        jobId = getIntent().getIntExtra(PARAM_ID,0);

        showProgress();

        presenter.loadData(jobId);

        bt_post.setOnClickListener(this);
        bt_collect.setOnClickListener(this);

        dialog = createDialog(this).build();
    }

    private void initToolBar() {
        toolbar.setTitle("职位详情");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
    }

    @Override
    protected List<Object> getModules() {
        return Arrays.<Object>asList(new JobDetailModule(this));
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        sv_content.setVisibility(View.INVISIBLE);
        layout_send.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
        layout_send.setVisibility(View.VISIBLE);
        sv_content.setVisibility(View.VISIBLE);
    }

    @Override
    public void addData(JobDetail jobDetail) {
        jobTitle = jobDetail.getTitle()+jobDetail.getCompany();

        Picasso.with(this)
                .load(jobDetail.getCompany_image())
                .into(img_company);
        tv_job_title.setText(jobDetail.getTitle());
        tv_job_company.setText(jobDetail.getCompany());
        tv_job_area.setText(jobDetail.getArea());
        tv_job_salary.setText(jobDetail.getSalary());
        tv_job_edu.setText(jobDetail.getEducation());
        tv_job_html.setText(Html.fromHtml(jobDetail.getInfo()));

        if (DBHelper.checkJobPosted(jobId)){
            bt_post.setBackground(ResourceHelper.getDrawable(R.drawable.background_bt_posted));
            bt_post.setText("已投递");
            bt_post.setClickable(false);
            Drawable drawable = ResourceHelper.getDrawable(R.mipmap.ic_job_detail_posted);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            bt_post.setCompoundDrawables(null, null, null, null);
        }

        if (DBHelper.checkJobCollected(jobId)){
            bt_collect.setBackground(ResourceHelper.getDrawable(R.drawable.background_bt_posted));
            bt_collect.setText("已收藏");
            bt_collect.setClickable(false);
            Drawable drawable = ResourceHelper.getDrawable(R.mipmap.ic_job_detail_collected);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            bt_collect.setCompoundDrawables(null, null, null, null);
        }

        hideProgress();
    }

    @Override
    public void postJobSuccess(boolean result) {
        if (result){
            dialog.dismiss();
            Toast.makeText(this,"投递成功",Toast.LENGTH_SHORT).show();
            bt_post.setBackground(ResourceHelper.getDrawable(R.drawable.background_bt_posted));
            bt_post.setText("已投递");
            bt_post.setClickable(false);
            Drawable drawable = ResourceHelper.getDrawable(R.mipmap.ic_job_detail_posted);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            bt_post.setCompoundDrawables(null, null, null, null);

            DBHelper.addPostedJob(jobId);
        }
    }

    @Override
    public void collectJobSuccess(boolean result) {
        if (result){
            dialog.dismiss();
            Toast.makeText(this,"收藏成功",Toast.LENGTH_SHORT).show();
            bt_collect.setBackground(ResourceHelper.getDrawable(R.drawable.background_bt_posted));
            bt_collect.setText("已收藏");
            bt_collect.setClickable(false);
            Drawable drawable = ResourceHelper.getDrawable(R.mipmap.ic_job_detail_collected);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            bt_collect.setCompoundDrawables(null, null, null, null);

            DBHelper.addCollectedJob(jobId);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_job_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            case R.id.action_share:
                showShare(jobTitle);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_job_detail_post:
                dialog.show();
                presenter.postJob(jobId);
                break;
            case R.id.bt_job_detail_collect:
                dialog.show();
                presenter.collectJob(jobId);
                break;
        }
    }

    private MaterialDialog.Builder createDialog(final Context context){
        MaterialDialog.Builder builder = new MaterialDialog.Builder(this)
                .title("正在上传")
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

    private void showShare(String jobTitle) {
        ShareSDK.initSDK(this);
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
//        oks.disableSSOWhenAuthorize();

        oks.setTitle(jobTitle);

        oks.setText("助你成为实力派");

        oks.setImageUrl("http://182.92.11.218/i/shixipai/logo180px.png");

        oks.setUrl("http://182.92.11.218/job/detail/"+String.valueOf(jobId));

        oks.show(this);
    }
}
