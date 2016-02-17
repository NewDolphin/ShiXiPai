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
import android.widget.Toast;

import com.shixipai.R;
import com.shixipai.bean.edit.BaseInfo;
import com.shixipai.bean.edit.EduInfo;
import com.shixipai.bean.edit.ProjectInfo;
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
public class ProjectInfoFragment extends Fragment implements View.OnClickListener, DatePickerDialog.OnDateSetListener {
    public final static String PARAM_TYPE = "project_info";

    private ResumeInfo resumeInfo;

    private EditActivity editActivity;

    @Bind(R.id.layout_project1)
    LinearLayout layout_project1;

    @Bind(R.id.layout_project1_start_time)
    LinearLayout layout_project1_start_time;

    @Bind(R.id.tv_project1_start_time)
    TextView tv_project1_start_time;

    @Bind(R.id.layout_project1_end_time)
    LinearLayout layout_project1_end_time;

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

    @Bind(R.id.layout_project2_end_time)
    LinearLayout layout_project2_end_time;

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

    @Bind(R.id.layout_project3_end_time)
    LinearLayout layout_project3_end_time;

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

    private int proCount = 0;

    //用来区分第几个项目信息的毕业时间
    private int timeTag = 1;

    public static ProjectInfoFragment getInstance(ResumeInfo resumeInfo){
        ProjectInfoFragment projectInfoFragment = new ProjectInfoFragment();

        Bundle bundle = new Bundle();
        bundle.putSerializable(PARAM_TYPE, resumeInfo);
        projectInfoFragment.setArguments(bundle);
        return projectInfoFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        resumeInfo = (ResumeInfo)getArguments().getSerializable(PARAM_TYPE);
        EditActivity editActivity = (EditActivity)getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_project_info,container,false);
        ButterKnife.bind(this, rootView);

        bindInfo();

        bindEvent();

        return rootView;
    }

    private void bindInfo() {
        if (resumeInfo.project_title_1 == null){
            proCount = 1;
        }else {
            proCount = 1;
            tv_project1_start_time.setText(resumeInfo.project_start_1);
            tv_project1_end_time.setText(resumeInfo.project_end_1);
            et_project1_title.setText(resumeInfo.project_title_1);
            et_project1_content.setText(resumeInfo.project_info_1);
        }
        if (resumeInfo.project_title_2 != null){
            proCount = 2;
            tv_project2_start_time.setText(resumeInfo.project_start_2);
            tv_project2_end_time.setText(resumeInfo.project_end_2);
            et_project2_title.setText(resumeInfo.project_title_2);
            et_project2_content.setText(resumeInfo.project_info_2);
        }
        if (resumeInfo.project_title_3 != null){
            proCount = 3;
            tv_project3_start_time.setText(resumeInfo.project_start_3);
            tv_project3_end_time.setText(resumeInfo.project_end_3);
            et_project3_title.setText(resumeInfo.project_title_3);
            et_project3_content.setText(resumeInfo.project_info_3);
        }

    }


    private void bindEvent() {
        layout_project1_start_time.setOnClickListener(this);
        layout_project1_end_time.setOnClickListener(this);
        layout_project2_start_time.setOnClickListener(this);
        layout_project2_end_time.setOnClickListener(this);
        layout_project2_start_time.setOnClickListener(this);
        layout_project2_end_time.setOnClickListener(this);
        bt_add_info.setOnClickListener(this);
        bt_next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.layout_project1_start_time:
                showDatePickerDialog();
                timeTag = 1;
                break;
            case R.id.layout_project1_end_time:
                showDatePickerDialog();
                timeTag = 2;
                break;
            case R.id.layout_project2_start_time:
                showDatePickerDialog();
                timeTag = 3;
                break;
            case R.id.layout_project2_end_time:
                showDatePickerDialog();
                timeTag = 4;
                break;
            case R.id.layout_project3_start_time:
                showDatePickerDialog();
                timeTag = 5;
                break;
            case R.id.layout_project3_end_time:
                showDatePickerDialog();
                timeTag = 6;
                break;
            case R.id.bt_add_info:
                if (proCount == 1){
                    layout_project2.setVisibility(View.VISIBLE);
                }else if (proCount == 2){
                    layout_project3.setVisibility(View.VISIBLE);
                }else {
                    Toast.makeText(getActivity(), "最多添加三条记录", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.bt_next:
                resumeInfo.project_title_1 = et_project2_title.getText().toString();
                resumeInfo.project_start_1 = tv_project2_start_time.getText().toString();
                resumeInfo.project_end_1 = tv_project2_end_time.getText().toString();
                resumeInfo.project_job_1 = et_project2_content.getText().toString();

                resumeInfo.project_title_2 = et_project2_title.getText().toString();
                resumeInfo.project_start_2 = tv_project2_start_time.getText().toString();
                resumeInfo.project_end_2 = tv_project2_end_time.getText().toString();
                resumeInfo.project_job_2 = et_project2_content.getText().toString();

                resumeInfo.project_title_2 = et_project2_title.getText().toString();
                resumeInfo.project_start_2 = tv_project2_start_time.getText().toString();
                resumeInfo.project_end_2 = tv_project2_end_time.getText().toString();
                resumeInfo.project_job_2 = et_project2_content.getText().toString();

                editActivity.viewPager.setCurrentItem(3);
                break;
        }
    }

    private void showDatePickerDialog(){
        Calendar now = Calendar.getInstance();
        DatePickerDialog dpd = DatePickerDialog.newInstance(
                ProjectInfoFragment.this,
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
                tv_project1_start_time.setText(dateContent);
                break;
            case 2:
                tv_project1_end_time.setText(dateContent);
                break;
            case 3:
                tv_project2_start_time.setText(dateContent);
                break;
            case 4:
                tv_project2_end_time.setText(dateContent);
                break;
            case 5:
                tv_project3_start_time.setText(dateContent);
                break;
            case 6:
                tv_project3_end_time.setText(dateContent);
                break;
        }
    }
}
