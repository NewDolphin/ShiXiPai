package com.shixipai.ui.search;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import com.shixipai.R;
import com.shixipai.api.ApiClient;
import com.shixipai.bean.JobItem;
import com.shixipai.support.ResourceHelper;
import com.shixipai.ui.BaseActivity;
import com.shixipai.ui.common.OnItemClickListener;
import com.shixipai.ui.jobClassify.jobClassifyDetail.JobClassifyDetailActivity;
import com.yyydjk.library.DropDownMenu;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by xiepeng on 16/2/3.
 */
public class SearchActivity extends BaseActivity implements SearchView, OnItemClickListener{
    @Inject
    SearchPresenter presenter;

    @Bind(R.id.dropDownMenu_search)
    DropDownMenu dropDownMenu;

    private SearchAdapter adapter;
    private LinearLayoutManager linearLayoutManager;

    //以下用来初始化选择控件
    private String headers[] = {"城市", "职位"};

    private String cityCondition = "全部";
    private String jobCondition = "全部";

    private List<View> popupViews = new ArrayList<>();

    private ListDropDownAdapter cityAdapter;
    private ListDropDownAdapter jobAdapter;

    private String citys[] = ResourceHelper.getStringArrays(R.array.job_place);
    private String jobs[] = ResourceHelper.getStringArrays(R.array.job_title);

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, SearchActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dropdown);
        ButterKnife.bind(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initView();
    }

    @Override
    protected List<Object> getModules() {
        return Arrays.<Object>asList(new SearchModule(this));
    }

    private void initView() {
        //init age menu
        final ListView cityView = new ListView(this);
        cityView.setDividerHeight(0);
        cityAdapter = new ListDropDownAdapter(this, Arrays.asList(citys));
        cityView.setAdapter(cityAdapter);

        //init sex menu
        final ListView jobView = new ListView(this);
        jobView.setDividerHeight(0);
        jobAdapter = new ListDropDownAdapter(this, Arrays.asList(jobs));
        jobView.setAdapter(jobAdapter);

        //init popupViews
        popupViews.add(cityView);
        popupViews.add(jobView);

        //add item click event
        cityView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                cityAdapter.setCheckItem(position);
                dropDownMenu.setTabText(citys[position]);
                cityCondition = String.valueOf(citys[position]);
                dropDownMenu.closeMenu();

                adapter.clear();
                adapter.notifyDataSetChanged();

                presenter.cancelRequest(getContext());
                presenter.firstTimeLoadJobItems(cityCondition,jobCondition);
            }
        });

        jobView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                jobAdapter.setCheckItem(position);
                dropDownMenu.setTabText(position == 0 ? headers[1] : jobs[position]);
                jobCondition = String.valueOf(position);
                dropDownMenu.closeMenu();

                adapter.clear();
                adapter.notifyDataSetChanged();

                presenter.cancelRequest(getContext());
                presenter.firstTimeLoadJobItems(cityCondition,jobCondition);
            }
        });

        LayoutInflater inflater3 = LayoutInflater.from(this);
        View view = inflater3.inflate(R.layout.activity_search, null);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        view.setLayoutParams(lp);

        dropDownMenu.setDropDownMenu(Arrays.asList(headers), popupViews, view);

        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.recyclerview_search);
        adapter = new SearchAdapter(this,this);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int lastPosition = linearLayoutManager.findLastCompletelyVisibleItemPosition();
                if ((lastPosition == linearLayoutManager.getItemCount() - 1) && dy > 0) {
                    presenter.loadMoreJobItems(cityCondition,jobCondition);
                }
            }
        });

        presenter.firstTimeLoadJobItems(cityCondition,jobCondition);

    }

    @Override
    public void onBackPressed() {
        //退出activity前关闭菜单
        if (dropDownMenu.isShowing()) {
            dropDownMenu.closeMenu();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void toastMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void addListData(List<JobItem> items) {
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
    public void startJobDetailActivity(int position) {
        JobItem jobItem = adapter.getItem(position);
        int id = jobItem.getId();

        Intent intent = new Intent(this, JobClassifyDetailActivity.class);
        intent.putExtra("id",id);
        startActivity(intent);
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void onItemClicked(View view, int position) {
        presenter.onItemClicked(view,position);
    }
}
