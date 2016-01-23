package com.shixipai.ui.jobClassify.jobClassifyList;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.shixipai.R;
import com.shixipai.bean.JobItem;
import com.shixipai.ui.BaseActivity;
import com.shixipai.ui.common.OnItemClickListener;
import com.shixipai.ui.job.list.JobListAdapter;

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

    private JobListAdapter adapter;
    private LinearLayoutManager linearLayoutManager;

    private int classify_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_classify_list);

        ButterKnife.bind(this);

        classify_id = getIntent().getIntExtra("tag",0)+1;

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

    }

    @Override
    public void onRefresh() {
        presenter.loadJobItems(classify_id);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
