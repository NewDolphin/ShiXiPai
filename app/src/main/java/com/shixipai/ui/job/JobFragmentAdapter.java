package com.shixipai.ui.job;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

import com.shixipai.R;
import com.shixipai.support.ResourceHelper;
import com.shixipai.ui.job.list.JobListFragment;


/**
 * Created by xiepeng on 16/1/19.
 */
public class JobFragmentAdapter extends FragmentPagerAdapter {

    private final String[] JOB_TAB_TITLES = ResourceHelper.getStringArrays(R.array.job_tab_titles);

    public JobFragmentAdapter(android.support.v4.app.FragmentManager fm){
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return JOB_TAB_TITLES[position];
    }

    @Override
    public Fragment getItem(int position) {
        return JobListFragment.getInstance(position);
    }

    @Override
    public int getCount() {
        return JOB_TAB_TITLES.length;
    }
}
