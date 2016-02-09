package com.shixipai.ui.edit.editinfo.edu;

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
import com.shixipai.bean.edit.BaseInfo;
import com.shixipai.bean.edit.EduInfo;
import com.shixipai.ui.edit.EditActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by xiepeng on 16/2/5.
 */
public class EduInfoFrragment extends Fragment {
    public final static String PARAM_TYPE = "edu_info";

    private BaseInfo baseInfo;

    private EditActivity editActivity;

    @Bind(R.id.layout_edu1)
    LinearLayout layout_edu1;

    @Bind(R.id.layout_edu1_start_time)
    LinearLayout layout_edu1_start_time;

    @Bind(R.id.tv_edu1_start_time)
    TextView tv_edu1_start_time;

    @Bind(R.id.layout_edu1_end_time)
    LinearLayout layout_edu1_end_time;

    @Bind(R.id.tv_edu1_end_time)
    TextView tv_edu1_end_time;

    @Bind(R.id.et_edu1_school)
    EditText et_edu1_school;

    @Bind(R.id.et_edu1_level)
    EditText et_edu1_level;

    @Bind(R.id.et_edu1_major)
    EditText et_edu1_major;



    @Bind(R.id.layout_edu2)
    LinearLayout layout_edu2;

    @Bind(R.id.layout_edu2_start_time)
    LinearLayout layout_edu2_start_time;

    @Bind(R.id.tv_edu2_start_time)
    TextView tv_edu2_start_time;

    @Bind(R.id.layout_edu2_end_time)
    LinearLayout layout_edu2_end_time;

    @Bind(R.id.tv_edu2_end_time)
    TextView tv_edu2_end_time;

    @Bind(R.id.et_edu2_school)
    EditText et_edu2_school;

    @Bind(R.id.et_edu2_level)
    EditText et_edu2_level;

    @Bind(R.id.et_edu2_major)
    EditText et_edu2_major;



    @Bind(R.id.layout_edu3)
    LinearLayout layout_edu3;

    @Bind(R.id.layout_edu3_start_time)
    LinearLayout layout_edu3_start_time;

    @Bind(R.id.tv_edu3_start_time)
    TextView tv_edu3_start_time;

    @Bind(R.id.layout_edu3_end_time)
    LinearLayout layout_edu3_end_time;

    @Bind(R.id.tv_edu3_end_time)
    TextView tv_edu3_end_time;

    @Bind(R.id.et_edu3_school)
    EditText et_edu3_school;

    @Bind(R.id.et_edu3_level)
    EditText et_edu3_level;

    @Bind(R.id.et_edu3_major)
    EditText et_edu3_major;


    @Bind(R.id.bt_add_info)
    Button bt_add_info;

    @Bind(R.id.bt_next)
    Button bt_next;

    private int eduCount = 1;

    public static EduInfoFrragment getInstance(EduInfo eduInfo){
        EduInfoFrragment eduInfoFrragment = new EduInfoFrragment();

        Bundle bundle = new Bundle();
        bundle.putSerializable(PARAM_TYPE, eduInfo);
        eduInfoFrragment.setArguments(bundle);
        return eduInfoFrragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_edu_info,container,false);
        ButterKnife.bind(this, rootView);


        return rootView;
    }
}
