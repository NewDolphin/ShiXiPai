package com.shixipai.ui.strategy.list;

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
import com.shixipai.bean.strategy.StrategyItem;
import com.shixipai.ui.BaseActivity;
import com.shixipai.ui.common.OnItemClickListener;
import com.shixipai.ui.interview.topic.InterviewTopicAdapter;
import com.shixipai.ui.interview.topic.InterviewTopicModule;
import com.shixipai.ui.interview.topic.InterviewTopicPresenter;
import com.shixipai.ui.strategy.detail.StrategyDetailActivity;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by xiepeng on 16/2/6.
 */
public class StrategyListActivity extends BaseActivity implements StrategyListView,OnItemClickListener{
    @Bind(R.id.toolbar_strategy_list)
    Toolbar toolbar;

    @Bind(R.id.recyclerview_strategy_list)
    RecyclerView recyclerView;

    @Inject
    StrategyListPresenter presenter;

    private StrategyListAdapter adapter;
    private LinearLayoutManager linearLayoutManager;

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, StrategyListActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strategy_list);

        ButterKnife.bind(this);

        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        adapter = new StrategyListAdapter(this,this);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int lastPosition = linearLayoutManager.findLastCompletelyVisibleItemPosition();
                if ((lastPosition == linearLayoutManager.getItemCount() - 1) && dy > 0) {
                    presenter.loadMoreStrategyItems();
                }
            }
        });

        presenter.firstTimeLoadStrategyItems();
    }

    @Override
    protected List<Object> getModules() {
        return Arrays.<Object>asList(new StrategyListModule(this));
    }

    @Override
    public void onItemClicked(View view, int position) {
        presenter.onItemClicked(view, position);
    }

    @Override
    public void toastMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void addListData(List<StrategyItem> items) {
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
    public void startStrategyDetailActivity(int postion) {
        StrategyDetailActivity.actionStart(this,adapter.dataSet.get(postion));
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
