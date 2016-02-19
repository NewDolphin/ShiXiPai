package com.shixipai.ui.edit.editinfo.edu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.shixipai.R;
import com.shixipai.bean.edit.BaseInfo;
import com.shixipai.bean.edit.EduInfo;
import com.shixipai.bean.edit.ResumeInfo;
import com.shixipai.ui.edit.EditActivity;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by xiepeng on 16/2/5.
 */
public class EduInfoFrragment extends Fragment implements View.OnClickListener, DatePickerDialog.OnDateSetListener {
    public final static String PARAM_TYPE = "edu_info";

    private ResumeInfo resumeInfo;

    private EditActivity editActivity;

    @Bind(R.id.layout_edu1)
    LinearLayout layout_edu1;

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

    private int eduCount = 0;

    //用来区分第几个教育信息的毕业时间
    private int timeTag = 1;

    public static EduInfoFrragment getInstance(ResumeInfo resumeInfo){
        EduInfoFrragment eduInfoFrragment = new EduInfoFrragment();

        Bundle bundle = new Bundle();
        bundle.putSerializable(PARAM_TYPE, resumeInfo);
        eduInfoFrragment.setArguments(bundle);
        return eduInfoFrragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        resumeInfo = (ResumeInfo)getArguments().getSerializable(PARAM_TYPE);
        editActivity = (EditActivity)getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_edu_info,container,false);
        ButterKnife.bind(this, rootView);

        bindInfo();

        bindEvent();

        return rootView;
    }

    private void bindInfo() {
        if (resumeInfo.school_1 == null){
            eduCount = 1;
        }else {
            eduCount = 1;
            tv_edu1_end_time.setText(resumeInfo.graduated_time_1);
            et_edu1_school.setText(resumeInfo.school_1);
            et_edu1_level.setText(resumeInfo.grade_1);
            et_edu1_major.setText(resumeInfo.professional_1);
        }
        if (resumeInfo.school_2 != null){
            eduCount = 2;
            tv_edu2_end_time.setText(resumeInfo.graduated_time_2);
            et_edu2_school.setText(resumeInfo.school_2);
            et_edu2_level.setText(resumeInfo.grade_2);
            et_edu2_major.setText(resumeInfo.professional_2);

            layout_edu2.setVisibility(View.VISIBLE);
        }
        if (resumeInfo.school_3 != null){
            eduCount = 3;
            tv_edu3_end_time.setText(resumeInfo.graduated_time_3);
            et_edu3_school.setText(resumeInfo.school_3);
            et_edu3_level.setText(resumeInfo.grade_3);
            et_edu3_major.setText(resumeInfo.professional_3);

            layout_edu3.setVisibility(View.VISIBLE);
        }
    }

    private void bindEvent() {
        layout_edu1_end_time.setOnClickListener(this);
        layout_edu2_end_time.setOnClickListener(this);
        layout_edu3_end_time.setOnClickListener(this);
        bt_add_info.setOnClickListener(this);
        bt_next.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.layout_edu1_end_time:
                showDatePickerDialog();
                timeTag = 1;
                break;
            case R.id.layout_edu2_end_time:
                showDatePickerDialog();
                timeTag = 2;
                break;
            case R.id.layout_edu3_end_time:
                showDatePickerDialog();
                timeTag = 3;
                break;
            case R.id.bt_add_info:
                Log.i("test","here");
                if (eduCount == 1){
                    layout_edu2.setVisibility(View.VISIBLE);
                    eduCount = 2;
                }else if (eduCount == 2){
                    layout_edu3.setVisibility(View.VISIBLE);
                    eduCount = 3;
                }else {
                    Toast.makeText(getActivity(),"最多添加三条记录",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.bt_next:
                resumeInfo.school_1 = et_edu1_school.getText().toString();
                resumeInfo.grade_1 = et_edu1_level.getText().toString();
                resumeInfo.graduated_time_1 = tv_edu1_end_time.getText().toString();
                resumeInfo.professional_1 = et_edu1_major.getText().toString();

                resumeInfo.school_2 = et_edu2_school.getText().toString();
                resumeInfo.grade_2 = et_edu2_level.getText().toString();
                resumeInfo.graduated_time_2 = tv_edu2_end_time.getText().toString();
                resumeInfo.professional_2 = et_edu2_major.getText().toString();

                resumeInfo.school_3 = et_edu3_school.getText().toString();
                resumeInfo.grade_3 = et_edu3_level.getText().toString();
                resumeInfo.graduated_time_3 = tv_edu3_end_time.getText().toString();
                resumeInfo.professional_3 = et_edu3_major.getText().toString();

                editActivity.viewPager.setCurrentItem(2);
                break;
        }

    }

    private void showDatePickerDialog(){
        Calendar now = Calendar.getInstance();
        DatePickerDialog dpd = DatePickerDialog.newInstance(
                EduInfoFrragment.this,
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
        );
        dpd.showYearPickerFirst(true);
        dpd.show(getActivity().getFragmentManager(), "Datepickerdialog");
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        String dateContent = dayOfMonth+"/"+(++monthOfYear)+"/"+year;

        switch (timeTag){
            case 1:
                tv_edu1_end_time.setText(dateContent);
                break;
            case 2:
                tv_edu2_end_time.setText(dateContent);
                break;
            case 3:
                tv_edu3_end_time.setText(dateContent);
                break;
        }
    }
}
