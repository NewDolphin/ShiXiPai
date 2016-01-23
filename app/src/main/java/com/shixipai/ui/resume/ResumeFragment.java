package com.shixipai.ui.resume;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shixipai.R;
import com.shixipai.ui.BaseFragment;

import java.util.List;

/**
 * Created by xiepeng on 16/1/19.
 */
public class ResumeFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_resume, container, false);

        return view;
    }

//    @Override
//    protected List<Object> getModules() {
//        return null;
//    }
}
