package com.shixipai.ui.interview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.shixipai.R;
import com.shixipai.ui.common.OnItemClickListener;
import com.shixipai.ui.interview.topic.InterviewTopicActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by xiepeng on 16/1/26.
 */
public class InterviewActivity extends AppCompatActivity implements OnItemClickListener{
    @Bind(R.id.toolbar_interview)
    Toolbar toolbar;

    @Bind(R.id.recyclerview_interview)
    RecyclerView recyclerView;

    private InterviewAdapter adapter;
    private LinearLayoutManager linearLayoutManager;

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, InterviewActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interview);
        ButterKnife.bind(this);

        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        adapter = new InterviewAdapter(this);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
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

    @Override
    public void onItemClicked(View view, int position) {
        switch (view.getId()) {
            case R.id.layout_interview:
                InterviewTopicActivity.actionStart(this, position);
                break;
        }
    }
}
