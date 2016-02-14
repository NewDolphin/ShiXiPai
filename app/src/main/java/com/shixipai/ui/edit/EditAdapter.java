package com.shixipai.ui.edit;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

import com.shixipai.bean.edit.ResumeInfo;
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

    public EditAdapter(android.support.v4.app.FragmentManager fm,ResumeInfo resumeInfo){
        super(fm);

        mFragments.add(BaseInfoFragment.getInstance(resumeInfo.getBaseInfo()));
        mFragments.add(EduInfoFrragment.getInstance(resumeInfo.getEduInfos()));
        mFragments.add(ProjectInfoFragment.getInstance(resumeInfo.getProjectInfos()));
        mFragments.add(WantInfoFragment.getInstance(resumeInfo.getWantInfo()));
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
