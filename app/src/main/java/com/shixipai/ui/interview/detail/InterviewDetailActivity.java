package com.shixipai.ui.interview.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.shixipai.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by xiepeng on 16/1/30.
 */
public class InterviewDetailActivity extends AppCompatActivity {
    @Bind(R.id.toolbar_interview_detail)
    Toolbar toolbar;

    @Bind(R.id.tv_interview_detail_q_index)
    TextView tv_q_index;

    @Bind(R.id.tv_interview_detail_q_content)
    TextView tv_q_content;

    @Bind(R.id.tv_interview_detail_a_index)
    TextView tv_a_index;

    @Bind(R.id.tv_interview_detail_a_content)
    TextView tv_a_content;

    @Bind(R.id.layout_interview_detail)
    RelativeLayout layout_detail;

    @Bind(R.id.sv_interview_detail)
    ScrollView sv_detail;

    @Bind(R.id.pb_interview_detail)
    ProgressBar progressBar;

    private static final String PARAM_POS = "postion";
    private static final String PARAM_Q = "question";
    private static final String PARAM_A = "answer";

    private int postion;
    private String question;
    private String answer;

    public static void actionStart(Context context, int postion, String question, String answer) {
        Intent intent = new Intent(context, InterviewDetailActivity.class);
        intent.putExtra(PARAM_POS, postion);
        intent.putExtra(PARAM_Q, question);
        intent.putExtra(PARAM_A, answer);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interview_detail);

        postion = getIntent().getIntExtra(PARAM_POS, 1);
        question = getIntent().getStringExtra(PARAM_Q);
        answer = getIntent().getStringExtra(PARAM_A);

        ButterKnife.bind(this);

        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        showProgress();
        bindData();
    }

    public void bindData(){
        tv_q_index.setText("Q"+String.valueOf(postion+1)+".");
        tv_q_content.setText(question);
        tv_a_index.setText("A"+String.valueOf(postion+1)+".");
        tv_a_content.setText(Html.fromHtml(answer));

        hideProgress();
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

    public void showProgress(){
        progressBar.setVisibility(View.VISIBLE);
        layout_detail.setVisibility(View.GONE);
        sv_detail.setVisibility(View.GONE);
    }


    public void hideProgress(){
        progressBar.setVisibility(View.GONE);
        layout_detail.setVisibility(View.VISIBLE);
        sv_detail.setVisibility(View.VISIBLE);
    }
}
