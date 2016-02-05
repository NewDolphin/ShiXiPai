package com.shixipai.ui.edit.editinfo.project;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shixipai.R;

/**
 * Created by xiepeng on 16/2/5.
 */
public class ProjectInfoFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_project_info,container,false);

        return rootView;
    }
}
