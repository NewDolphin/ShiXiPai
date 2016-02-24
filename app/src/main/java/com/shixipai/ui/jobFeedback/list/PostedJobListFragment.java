package com.shixipai.ui.jobFeedback.list;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.shixipai.R;
import com.shixipai.bean.JobItem;
import com.shixipai.bean.jobfeedback.JobFeedBack;
import com.shixipai.support.PrefUtils;
import com.shixipai.ui.BaseFragment;
import com.shixipai.ui.common.OnItemClickListener;
import com.shixipai.ui.home.HomeAdapter;
import com.shixipai.ui.home.HomeModule;
import com.shixipai.ui.jobFeedback.detail.PostedJobDetailActivity;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by xiepeng on 16/2/22.
 */
public class PostedJobListFragment extends BaseFragment implements PostedJobListView, OnItemClickListener {
    @Inject
    PostedJobListPresenter presenter;

    @Bind(R.id.recyclerview_posted_job)
    RecyclerView recyclerView;

    private PostedJobListAdapter adapter;
    private LinearLayoutManager linearLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_posted_job_list, container, false);

        ButterKnife.bind(this, view);

        adapter = new PostedJobListAdapter(getActivity(),this);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int lastPosition = linearLayoutManager.findLastCompletelyVisibleItemPosition();
                if ((lastPosition == linearLayoutManager.getItemCount() - 1) && dy > 0) {
                    presenter.loadMoreJobItems();
                }
            }
        });

        presenter.firstTimeLoadJobItems();

        return view;
    }

    @Override
    protected List<Object> getModules() {
        return Arrays.<Object>asList(new PostedJobModule(this));
    }

    @Override
    public void toastMessage(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void addListData(List<JobFeedBack> items) {
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
    public void startJobFeedbackDetailActivity(int position) {
        PostedJobDetailActivity.actionStart(getActivity(),adapter.dataSet.get(position));
    }

    @Override
    public void onItemClicked(View view, int position) {
        presenter.onItemClicked(view,position);
    }
}
