package com.shixipai.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.shixipai.R;
import com.shixipai.bean.JobDetail;
import com.shixipai.bean.JobItem;
import com.shixipai.support.PrefUtils;
import com.shixipai.ui.BaseFragment;
import com.shixipai.ui.common.OnItemClickListener;
import com.shixipai.ui.interview.InterviewActivity;
import com.shixipai.ui.jobClassify.JobClassifyActivity;
import com.shixipai.ui.jobClassify.jobClassifyDetail.JobClassifyDetailActivity;
import com.shixipai.ui.jobClassify.jobClassifyList.JobClassifyListPresenter;
import com.shixipai.ui.jobClassify.jobClassifyList.JobListAdapter;
import com.shixipai.ui.strategy.list.StrategyListActivity;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by xiepeng on 16/1/19.
 */
public class HomeFragment extends BaseFragment implements HomeView,OnItemClickListener,View.OnClickListener {
    @Inject
    HomeListPresenter presenter;

    @Bind(R.id.layout_home_tag)
    LinearLayout layout_tag;

    @Bind(R.id.layout_home_classify)
    LinearLayout layout_classify;

    @Bind(R.id.layout_home_skill)
    LinearLayout layout_skill;

    @Bind(R.id.layout_home_interview)
    LinearLayout layout_interview;

    @Bind(R.id.home_recycler_view)
    RecyclerView recyclerView;

    private HomeAdapter adapter;
    private LinearLayoutManager linearLayoutManager;

    @Override
    public Context getContext() {
        return getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ButterKnife.bind(this, view);

        layout_classify.setOnClickListener(this);
        layout_interview.setOnClickListener(this);
        layout_skill.setOnClickListener(this);

        adapter = new HomeAdapter(getActivity(),this);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int lastPosition = linearLayoutManager.findLastCompletelyVisibleItemPosition();
                int firstCompletePostion = linearLayoutManager.findFirstCompletelyVisibleItemPosition();

                if ((firstCompletePostion == 1)&&dy > 0) {
                    layout_tag.setVisibility(View.GONE);
                }
                if ((firstCompletePostion == 2)&&dy < 0){
                    layout_tag.setVisibility(View.VISIBLE);
                }
                if ((lastPosition == linearLayoutManager.getItemCount() - 1) && dy > 0) {
                    presenter.loadMoreJobItems(PrefUtils.getCityCondition(),PrefUtils.getJobCondition());
                }
            }
        });

        presenter.firstTimeLoadJobItems(PrefUtils.getCityCondition(),PrefUtils.getJobCondition());

        return view;
    }

    @Override
    protected List<Object> getModules() {
        return Arrays.<Object>asList(new HomeModule(this));
    }

    @Override
    public void addListData(List<JobItem> items) {
        adapter.addData(items);
    }

    @Override
    public void startJobDetailActivity(int position) {
        JobItem jobItem = adapter.getItem(position);
        int id = jobItem.getId();

        Intent intent = new Intent(getActivity(), JobClassifyDetailActivity.class);
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
    public void toastMessage(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onItemClicked(View view, int position) {
        presenter.onItemClicked(view,position);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.layout_home_classify:
                Intent intent1 = new Intent(getActivity(), JobClassifyActivity.class);
                startActivity(intent1);
                break;
            case R.id.layout_home_interview:
                InterviewActivity.actionStart(getActivity());
                break;
            case R.id.layout_home_skill:
                StrategyListActivity.actionStart(getActivity());
                break;
        }
    }
}
