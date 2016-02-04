package com.shixipai.ui.search;

import android.content.Context;
import android.view.View;

import com.shixipai.R;
import com.shixipai.bean.JobItem;
import com.shixipai.bean.JobResponse;
import com.shixipai.interactor.search.SearchInteractor;
import com.shixipai.support.ResourceHelper;
import com.shixipai.ui.common.job.OnGetJobItemsCallback;
import java.util.List;

/**
 * Created by xiepeng on 16/2/3.
 */
public class SearchPresenterImpl implements SearchPresenter, OnGetJobItemsCallback {
    private SearchView searchView;
    private SearchInteractor interactor;

    private boolean isFirstTimeLoad = true;
    private boolean isLoadMore = false;

    private int page = 1;

    public SearchPresenterImpl(SearchView searchView, SearchInteractor searchInteractor) {
        this.searchView = searchView;
        this.interactor = searchInteractor;
    }

    @Override
    public void firstTimeLoadJobItems(String cityCondition,String jobCondition) {
        page = 1;
        searchView.showFooter();
        getJobItems(searchView.getContext(),cityCondition,jobCondition);
    }

    @Override
    public void loadMoreJobItems(String cityCondition,String jobCondition) {
        if(isLoadMore){return;}
        page += 1;
        isLoadMore = true;
        searchView.showFooter();
        getJobItems(searchView.getContext(),cityCondition, jobCondition);
    }

    @Override
    public void onItemClicked(View v, int position) {
        switch (v.getId()) {
            case R.id.bt_job_item_commit:
                searchView.startJobDetailActivity(position);
                break;
        }
    }

    @Override
    public void cancelRequest(Context context) {
        interactor.cancelRequest(context);
    }

    @Override
    public void onSuccess(JobResponse jobResponse) {
        if (jobResponse.rows.size() > 0) {
            List<JobItem> items = jobResponse.rows;
            if(isFirstTimeLoad){
                searchView.addListData(items);
                searchView.hideFooter();
                isFirstTimeLoad = !isFirstTimeLoad;
            }else {
                searchView.addListData(items);
                isLoadMore = false;
            }
        } else {
            searchView.hideFooter();
            this.searchView.toastMessage(ResourceHelper.getString(R.string.no_more_information));
        }
        isLoadMore = false;
    }

    @Override
    public void onFailed(String errorString) {
        page -= 1;
        this.searchView.toastMessage(errorString);
        isLoadMore = false;
    }

    private void getJobItems(Context context,String cityCondition,String jobCondition) {
        this.interactor.getJobItems(context,page,cityCondition,jobCondition, this);
    }
}
