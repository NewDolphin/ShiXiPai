package com.shixipai.ui.edit;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

import com.shixipai.bean.edit.BaseInfo;
import com.shixipai.bean.edit.EduInfo;
import com.shixipai.bean.edit.ProjectInfo;
import com.shixipai.bean.edit.ResumeInfo;
import com.shixipai.bean.edit.WantInfo;
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

        mFragments.add(BaseInfoFragment.getInstance(resumeInfo));
        mFragments.add(EduInfoFrragment.getInstance(resumeInfo));
        mFragments.add(ProjectInfoFragment.getInstance(resumeInfo));
        mFragments.add(WantInfoFragment.getInstance(resumeInfo));
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
