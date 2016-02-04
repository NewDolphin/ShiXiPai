package com.shixipai.ui.interview.question;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.shixipai.R;
import com.shixipai.bean.interview.InterviewQuestionItem;
import com.shixipai.bean.interview.InterviewTopicItem;
import com.shixipai.ui.BaseActivity;
import com.shixipai.ui.common.DividerItemDecoration;
import com.shixipai.ui.common.OnItemClickListener;
import com.shixipai.ui.interview.detail.InterviewDetailActivity;
import com.shixipai.ui.interview.topic.InterviewTopicAdapter;
import com.shixipai.ui.interview.topic.InterviewTopicModule;
import com.shixipai.ui.interview.topic.InterviewTopicPresenter;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by xiepeng on 16/1/30.
 */
public class InterviewQuestionActivity extends BaseActivity implements InterviewQuestionView, OnItemClickListener{
    @Bind(R.id.toolbar_interview_question)
    Toolbar toolbar;

    @Bind(R.id.recyclerview_interview_question)
    RecyclerView recyclerView;

    @Inject
    InterviewQuestionPresenter presenter;

    private InterviewQuestionAdapter adapter;
    private LinearLayoutManager linearLayoutManager;

    private int tid;

    private static final String PARAM_ID = "tid";

    public static void actionStart(Context context, int tid) {
        Intent intent = new Intent(context, InterviewQuestionActivity.class);
        intent.putExtra(PARAM_ID, tid);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interview_question);

        ButterKnife.bind(this);

        tid = getIntent().getIntExtra(PARAM_ID,1);

        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        adapter = new InterviewQuestionAdapter(this,this);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int lastPosition = linearLayoutManager.findLastCompletelyVisibleItemPosition();
                if ((lastPosition == linearLayoutManager.getItemCount() - 1) && dy > 0) {
                    presenter.loadMoreJobItems(tid);
                }
            }
        });

        presenter.firstTimeLoadJobItems(tid);
    }

    @Override
    public void toastMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void addListData(List<InterviewQuestionItem> items) {
        adapter.addData(items);
    }

    @Override
    public void showFooter() {
        adapter.setUseFooter(true);
    }

    @Override
    public void hideFooter() {
        adapter.setUseFooter(false);
    }

    @Override
    public void startInterviewDetailActivity(int postion) {
        InterviewDetailActivity.actionStart(this, postion,adapter.dataSet.get(postion).getTitle()
                ,adapter.dataSet.get(postion).getAnswer());
    }

    @Override
    public void addItemDecoration() {
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));
    }

    @Override
    protected List<Object> getModules() {
        return Arrays.<Object>asList(new InterviewQuestionModule(this));
    }

    @Override
    public void onItemClicked(View view, int position) {
        presenter.onItemClicked(view, position);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        ButterKnife.unbind(this);
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
