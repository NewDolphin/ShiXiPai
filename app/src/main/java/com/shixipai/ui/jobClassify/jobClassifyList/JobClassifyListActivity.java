package com.shixipai.ui.jobClassify.jobClassifyList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.shixipai.R;
import com.shixipai.bean.JobItem;
import com.shixipai.ui.BaseActivity;
import com.shixipai.ui.common.OnItemClickListener;
import com.shixipai.ui.jobClassify.jobClassifyDetail.JobClassifyDetailActivity;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by xiepeng on 16/1/23.
 */
public class JobClassifyListActivity extends BaseActivity implements JobClassifyListView,
        SwipeRefreshLayout.OnRefreshListener,OnItemClickListener {

    @Inject
    JobClassifyListPresenter presenter;

    @Bind(R.id.job_classify_list_recycler_view)
    RecyclerView recyclerView;

    @Bind(R.id.job_classify_list_swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    @Bind(R.id.toolbar_job_classify_list)
    Toolbar toolbar;

    private JobListAdapter adapter;
    private LinearLayoutManager linearLayoutManager;

    private int classify_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_classify_list);

        ButterKnife.bind(this);

        classify_id = getIntent().getIntExtra("tag",0)+1;

        initToolbar();

        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.color_primary));
        swipeRefreshLayout.setOnRefreshListener(this);

        adapter = new JobListAdapter(this,this);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int lastPosition = linearLayoutManager.findLastCompletelyVisibleItemPosition();
                if ((lastPosition == linearLayoutManager.getItemCount() - 1) && dy > 0) {
                    presenter.loadMoreJobItems(classify_id);
                }
            }
        });

        presenter.firstTimeLoadJobItems(classify_id);
    }

    private void initToolbar() {
        switch (classify_id){
            case 1:
                toolbar.setTitle("互联网");
                break;
            case 2:
                toolbar.setTitle("金融/法律");
                break;
            case 3:
                toolbar.setTitle("建设工程");
                break;
            case 4:
                toolbar.setTitle("销售/推广");
                break;
            case 5:
                toolbar.setTitle("人力资源/产品");
                break;
            case 6:
                toolbar.setTitle("汽车/制造");
                break;
            case 7:
                toolbar.setTitle("文化/传媒");
                break;
            case 8:
                toolbar.setTitle("教育/医疗");
                break;
            case 9:
                toolbar.setTitle("文案/管理");
                break;
        }

        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
    }

    @Override
    protected List<Object> getModules() {
        return Arrays.<Object>asList(new JobClassifyListModule(this));
    }

    @Override
    public void startRefresh() {
        if(!swipeRefreshLayout.isRefreshing()){
            swipeRefreshLayout.setRefreshing(true);
        }
    }

    @Override
    public void stopRefresh() {
        if(swipeRefreshLayout.isRefreshing()){
            swipeRefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void toastMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void updateListData(List<JobItem> items) {
        adapter.updateData(items);
    }

    @Override
    public void addListData(List<JobItem> items) {
        adapter.addData(items);
    }

    @Override
    public void startJobDetailActivity(int position) {
        JobItem jobItem = adapter.getItem(position);
        int id = jobItem.getId();

        Intent intent = new Intent(this, JobClassifyDetailActivity.class);
        intent.putExtra("id",id);
        startActivity(intent);
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
    public void onItemClicked(View view, int position) {
        presenter.onItemClicked(view,position);
    }

    @Override
    public void onRefresh() {
        presenter.loadJobItems(classify_id);
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
