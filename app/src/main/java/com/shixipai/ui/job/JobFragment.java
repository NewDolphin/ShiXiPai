package com.shixipai.ui.job;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shixipai.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by xiepeng on 16/1/19.
 */
public class JobFragment extends Fragment {
    @Bind(R.id.tabs_job)
    TabLayout mTabLayout;

    @Bind(R.id.viewpager_job)
    ViewPager _viewPager;

    public JobFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_job,container,false);
        ButterKnife.bind(this, rootView);

//        FragmentPagerAdapter fragmentPagerAdapter = new JobFragmentAdapter(getChildFragmentManager());
//        _viewPager.setAdapter(fragmentPagerAdapter);
//        mTabLayout.setupWithViewPager(_viewPager);

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

}
