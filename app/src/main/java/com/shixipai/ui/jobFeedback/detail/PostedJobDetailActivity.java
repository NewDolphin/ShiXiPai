package com.shixipai.ui.jobFeedback.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.shixipai.R;
import com.shixipai.bean.jobfeedback.JobFeedBack;
import com.shixipai.bean.strategy.StrategyItem;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by xiepeng on 16/2/24.
 */
public class PostedJobDetailActivity extends AppCompatActivity {
    @Bind(R.id.job_feedback_detail_toolbar)
    Toolbar toolbar;

    @Bind(R.id.pb_job_feedback_detail)
    ProgressBar progressBar;

    @Bind(R.id.iv_job_feedback_item)
    ImageView iv_job_feedback_item;

    @Bind(R.id.tv_job_title)
    TextView tv_job_title;

    @Bind(R.id.tv_job_area)
    TextView tv_job_area;

    @Bind(R.id.tv_job_salary)
    TextView tv_job_salary;

    @Bind(R.id.tv_job_time)
    TextView tv_job_time;

    @Bind(R.id.tv_job_state)
    TextView tv_job_state;

    @Bind(R.id.circle_step_1)
    View circle_step_1;

    @Bind(R.id.line_step_1)
    View line_step_1;

    @Bind(R.id.tv_step1_title)
    TextView tv_step1_title;

    @Bind(R.id.tv_step1_time)
    TextView tv_step1_time;

    @Bind(R.id.circle_step_2)
    View circle_step_2;

    @Bind(R.id.line_step_2)
    View line_step_2;

    @Bind(R.id.tv_step2_title)
    TextView tv_step2_title;

    @Bind(R.id.tv_step2_time)
    TextView tv_step2_time;

    @Bind(R.id.circle_step_3)
    View circle_step_3;

    @Bind(R.id.tv_step3_title)
    TextView tv_step3_title;

    @Bind(R.id.tv_step3_info)
    TextView tv_step3_info;

    private static final String PARAM_ID = "jobFeedbackItem";

    private JobFeedBack jobFeedBackItem;

    public static void actionStart(Context context,JobFeedBack jobFeedBack) {
        Intent intent = new Intent(context, PostedJobDetailActivity.class);

        Bundle bundle = new Bundle();
        bundle.putSerializable(PARAM_ID, jobFeedBack);
        intent.putExtras(bundle);

        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posted_job_detail);

        ButterKnife.bind(this);

        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        jobFeedBackItem = (JobFeedBack)getIntent().getSerializableExtra(PARAM_ID);

        bindInfo(jobFeedBackItem);
    }

    private void bindInfo(JobFeedBack jobItem) {
        Picasso.with(this)
                .load(jobItem.getCompany_image())
                .into(iv_job_feedback_item);
        tv_job_title.setText(jobItem.getIntern_title());
        tv_job_area.setText(jobItem.getArea());
        tv_job_salary.setText(jobItem.getSalary());
        if (jobItem.getStart_time()!=null){
            String jobTime = jobItem.getStart_time().substring(0,10);
            tv_job_time.setText(jobTime);
        }

        if (jobItem.getState3_title()!= null){
            tv_job_state.setText(jobItem.getState3_keyword());
            tv_step1_title.setText(jobItem.getState1_title());
            tv_step1_time.setText(jobItem.getState1_time());
            tv_step2_title.setText(jobItem.getState2_title());
            tv_step2_time.setText(jobItem.getState2_time());
            tv_step3_title.setText(jobItem.getState3_title());
            tv_step3_info.setText(jobItem.getState3_info());
        }else if (jobItem.getState2_title()!= null){
            tv_job_state.setText(jobItem.getState2_keyword());
            tv_step1_title.setText(jobItem.getState1_title());
            tv_step1_time.setText(jobItem.getState1_time());
            tv_step2_title.setText(jobItem.getState2_title());
            tv_step2_time.setText(jobItem.getState2_time());
            circle_step_3.setVisibility(View.GONE);
            line_step_2.setVisibility(View.GONE);
            tv_step3_title.setVisibility(View.GONE);
            tv_step3_info.setVisibility(View.GONE);
        }else {
            tv_job_state.setText(jobItem.getState1_keyword());
            tv_step1_title.setText(jobItem.getState1_title());
            tv_step1_time.setText(jobItem.getState1_time());
            circle_step_2.setVisibility(View.GONE);
            circle_step_3.setVisibility(View.GONE);
            line_step_1.setVisibility(View.GONE);
            line_step_2.setVisibility(View.GONE);
            tv_step2_title.setVisibility(View.GONE);
            tv_step2_time.setVisibility(View.GONE);
            tv_step3_title.setVisibility(View.GONE);
            tv_step3_info.setVisibility(View.GONE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
