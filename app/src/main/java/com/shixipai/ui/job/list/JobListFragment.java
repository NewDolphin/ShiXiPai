package com.shixipai.ui.job.list;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.shixipai.R;
import com.shixipai.bean.JobItem;
import com.shixipai.ui.BaseFragment;
import com.shixipai.ui.common.OnItemClickListener;
import com.shixipai.ui.jobClassify.jobClassifyList.JobListAdapter;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by xiepeng on 16/1/19.
 */

public class JobListFragment extends BaseFragment implements JobListView,
        SwipeRefreshLayout.OnRefreshListener,OnItemClickListener{

    public final static String LOG_TAG = JobListFragment.class.getSimpleName();

    //标识是哪个fragment
    public final static String PARAM_TYPE = "type";
    private int type;

    @Inject
    JobListPresenter jobListPresenter;

    @Bind(R.id.job_list_recycler_view)
    RecyclerView recyclerView;

    @Bind(R.id.job_list_swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    private JobListAdapter jobListAdapter;
    private LinearLayoutManager linearLayoutManager;
    private boolean isFirstTimeVisibleToUser = true;

    public JobListFragment() {
        // Required empty public constructor
    }

    public static JobListFragment getInstance(int position){
        JobListFragment jobListFragment = new JobListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(JobListFragment.PARAM_TYPE, position);
        jobListFragment.setArguments(bundle);
        return jobListFragment;
    }

    @Override
    protected List<Object> getModules() {
        return Arrays.<Object>asList(new JobListModule(this));
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        type = getArguments().getInt(PARAM_TYPE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_job_list,container,false);

        ButterKnife.bind(this, rootView);

        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.color_primary));
        swipeRefreshLayout.setOnRefreshListener(this);

        jobListAdapter = new JobListAdapter(getActivity(),this);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(jobListAdapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener(){
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int lastPosition = linearLayoutManager.findLastCompletelyVisibleItemPosition();
                if( (lastPosition == linearLayoutManager.getItemCount() - 1 ) && dy > 0 ){
                    jobListPresenter.loadMoreJobItems(type);
                }
            }
        });

        jobListPresenter.firstTimeLoadJobItems(type);

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onStart() {
        super.onStart();
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
        Toast.makeText(getActivity(),msg,Toast.LENGTH_LONG).show();
    }

    @Override
    public void updateListData(List<JobItem> items) {
        jobListAdapter.updateData(items);
    }

    @Override
    public void addListData(List<JobItem> items) {
        jobListAdapter.addData(items);
    }

    @Override
    public void startJobDetailActivity(int position) {

    }

    @Override
    public void showFooter() {
        jobListAdapter.setUseFooter(true);
    }

    @Override
    public void hideFooter() {
        jobListAdapter.setUseFooter(false);
    }


    @Override
    public void onRefresh() {
        jobListPresenter.loadJobItems(type);
    }

    @Override
    public void onItemClicked(View view, int position) {
        jobListPresenter.onItemClicked(view,position);
    }
}
