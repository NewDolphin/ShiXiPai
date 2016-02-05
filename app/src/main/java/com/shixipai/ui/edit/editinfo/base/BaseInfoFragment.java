package com.shixipai.ui.edit.editinfo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shixipai.R;
import com.shixipai.ui.BaseFragment;

import java.util.List;

/**
 * Created by xiepeng on 16/2/5.
 */
public class BaseInfoFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_base_info,container,false);

        return rootView;
    }
}
