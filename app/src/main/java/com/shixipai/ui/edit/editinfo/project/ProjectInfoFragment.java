package com.shixipai.ui.edit.editinfo.project;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shixipai.R;

import butterknife.Bind;

/**
 * Created by xiepeng on 16/2/5.
 */
public class ProjectInfoFragment extends Fragment {
    @Bind(R.id.layout_project1)
    LinearLayout layout_project1;

    @Bind(R.id.layout_project1_start_time)
    LinearLayout layout_project1_start_time;

    @Bind(R.id.tv_project1_start_time)
    TextView tv_project1_start_time;

    @Bind(R.id.layout_edu1_end_time)
    LinearLayout layout_edu1_end_time;

    @Bind(R.id.tv_project1_end_time)
    TextView tv_project1_end_time;

    @Bind(R.id.et_project1_title)
    EditText et_project1_title;

    @Bind(R.id.et_project1_content)
    EditText et_project1_content;


    @Bind(R.id.layout_project2)
    LinearLayout layout_project2;

    @Bind(R.id.layout_project2_start_time)
    LinearLayout layout_project2_start_time;

    @Bind(R.id.tv_project2_start_time)
    TextView tv_project2_start_time;

    @Bind(R.id.layout_edu2_end_time)
    LinearLayout layout_edu2_end_time;

    @Bind(R.id.tv_project2_end_time)
    TextView tv_project2_end_time;

    @Bind(R.id.et_project2_title)
    EditText et_project2_title;

    @Bind(R.id.et_project2_content)
    EditText et_project2_content;


    @Bind(R.id.layout_project3)
    LinearLayout layout_project3;

    @Bind(R.id.layout_project3_start_time)
    LinearLayout layout_project3_start_time;

    @Bind(R.id.tv_project3_start_time)
    TextView tv_project3_start_time;

    @Bind(R.id.layout_edu3_end_time)
    LinearLayout layout_edu3_end_time;

    @Bind(R.id.tv_project3_end_time)
    TextView tv_project3_end_time;

    @Bind(R.id.et_project3_title)
    EditText et_project3_title;

    @Bind(R.id.et_project3_content)
    EditText et_project3_content;


    @Bind(R.id.bt_add_info)
    Button bt_add_info;

    @Bind(R.id.bt_next)
    Button bt_next;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_project_info,container,false);

        return rootView;
    }
}
