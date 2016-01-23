package com.shixipai.ui;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.shixipai.ShiXiPaiApp;

import java.util.List;

import dagger.ObjectGraph;

/**
 * Created by xiepeng on 16/1/13.
 */
public abstract class BaseFragment extends Fragment {

    private ObjectGraph mFragmentGraph;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mFragmentGraph = ((ShiXiPaiApp) activity.getApplication()).createScopedGraph(getModules().toArray());
        mFragmentGraph.inject(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
//        ApiClient.getInstance().cancelRequests(getActivity(), false);
    }

    protected abstract List<Object> getModules();
}
