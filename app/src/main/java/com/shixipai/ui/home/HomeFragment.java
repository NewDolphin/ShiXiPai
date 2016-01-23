package com.shixipai.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.shixipai.R;
import com.shixipai.ui.BaseFragment;
import com.shixipai.ui.jobClassify.JobClassifyActivity;

import java.util.List;

/**
 * Created by xiepeng on 16/1/19.
 */
public class HomeFragment extends Fragment {


//    @Override
//    protected List<Object> getModules() {
//        return null;
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        Button button = (Button)view.findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), JobClassifyActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
