package com.shixipai.ui.edit;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

import com.shixipai.ui.edit.editinfo.base.BaseInfoFragment;
import com.shixipai.ui.edit.editinfo.edu.EduInfoFrragment;
import com.shixipai.ui.edit.editinfo.project.ProjectInfoFragment;
import com.shixipai.ui.edit.editinfo.want.WantInfoFragment;

import java.util.ArrayList;

/**
 * Created by xiepeng on 16/2/5.
 */
public class EditAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> mFragments = new ArrayList<Fragment>();
    Fragment mTab01 = new BaseInfoFragment();
    Fragment mTab02 = new EduInfoFrragment();
    Fragment mTab03 = new ProjectInfoFragment();
    Fragment mTab04 = new WantInfoFragment();



    public EditAdapter(android.support.v4.app.FragmentManager fm){
        super(fm);
        mFragments.add(mTab01);
        mFragments.add(mTab02);
        mFragments.add(mTab03);
        mFragments.add(mTab04);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
