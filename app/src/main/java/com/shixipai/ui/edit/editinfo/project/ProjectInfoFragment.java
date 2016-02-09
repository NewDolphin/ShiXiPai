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

    private ArrayList<ProjectInfo> projectInfos = new ArrayList<ProjectInfo>();

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

    public static ProjectInfoFragment getInstance(ArrayList<ProjectInfo> projectInfos){
        ProjectInfoFragment projectInfoFragment = new ProjectInfoFragment();

        Bundle bundle = new Bundle();
        bundle.putSerializable(PARAM_TYPE, projectInfos);
        projectInfoFragment.setArguments(bundle);
        return projectInfoFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        projectInfos = (ArrayList<ProjectInfo>)getArguments().getSerializable(PARAM_TYPE);
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
        switch(projectInfos.size()) {
            case 0:
                proCount = 1;
                break;
            case 1:
                proCount = 1;
                tv_project1_start_time.setText(projectInfos.get(0).getStart_time());
                tv_project1_end_time.setText(projectInfos.get(0).getEnd_time());
                et_project1_title.setText(projectInfos.get(0).getTitle());
                et_project1_content.setText(projectInfos.get(0).getContent());
                break;
            case 2:
                proCount = 2;
                tv_project1_start_time.setText(projectInfos.get(0).getStart_time());
                tv_project1_end_time.setText(projectInfos.get(0).getEnd_time());
                et_project1_title.setText(projectInfos.get(0).getTitle());
                et_project1_content.setText(projectInfos.get(0).getContent());

                tv_project2_start_time.setText(projectInfos.get(1).getStart_time());
                tv_project2_end_time.setText(projectInfos.get(1).getEnd_time());
                et_project2_title.setText(projectInfos.get(1).getTitle());
                et_project2_content.setText(projectInfos.get(1).getContent());

                layout_project2.setVisibility(View.VISIBLE);
                break;
            case 3:
                proCount = 3;
                tv_project1_start_time.setText(projectInfos.get(0).getStart_time());
                tv_project1_end_time.setText(projectInfos.get(0).getEnd_time());
                et_project1_title.setText(projectInfos.get(0).getTitle());
                et_project1_content.setText(projectInfos.get(0).getContent());

                tv_project2_start_time.setText(projectInfos.get(1).getStart_time());
                tv_project2_end_time.setText(projectInfos.get(1).getEnd_time());
                et_project2_title.setText(projectInfos.get(1).getTitle());
                et_project2_content.setText(projectInfos.get(1).getContent());

                tv_project3_start_time.setText(projectInfos.get(2).getStart_time());
                tv_project3_end_time.setText(projectInfos.get(2).getEnd_time());
                et_project3_title.setText(projectInfos.get(2).getTitle());
                et_project3_content.setText(projectInfos.get(2).getContent());

                layout_project3.setVisibility(View.VISIBLE);
                layout_project2.setVisibility(View.VISIBLE);
                break;
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
                editActivity.resumeInfo.getProjectInfos().clear();
                switch (proCount){
                    case 1:
                        ProjectInfo projectInfo_1_1 = new ProjectInfo(et_project1_title.getText().toString(),
                                                                      tv_project1_start_time.getText().toString(),
                                                                      tv_project1_end_time.getText().toString(),
                                                                      et_project1_content.getText().toString());
                        editActivity.resumeInfo.getProjectInfos().add(projectInfo_1_1);
                        break;
                    case 2:
                        ProjectInfo projectInfo_2_1 = new ProjectInfo(et_project1_title.getText().toString(),
                                tv_project1_start_time.getText().toString(),
                                tv_project1_end_time.getText().toString(),
                                et_project1_content.getText().toString());
                        ProjectInfo projectInfo_2_2 = new ProjectInfo(et_project2_title.getText().toString(),
                                tv_project2_start_time.getText().toString(),
                                tv_project2_end_time.getText().toString(),
                                et_project2_content.getText().toString());
                        editActivity.resumeInfo.getProjectInfos().add(projectInfo_2_1);
                        editActivity.resumeInfo.getProjectInfos().add(projectInfo_2_2);
                        break;
                    case 3:
                        ProjectInfo projectInfo_3_1 = new ProjectInfo(et_project1_title.getText().toString(),
                                tv_project1_start_time.getText().toString(),
                                tv_project1_end_time.getText().toString(),
                                et_project1_content.getText().toString());
                        ProjectInfo projectInfo_3_2 = new ProjectInfo(et_project2_title.getText().toString(),
                                tv_project2_start_time.getText().toString(),
                                tv_project2_end_time.getText().toString(),
                                et_project2_content.getText().toString());
                        ProjectInfo projectInfo_3_3 = new ProjectInfo(et_project3_title.getText().toString(),
                                tv_project3_start_time.getText().toString(),
                                tv_project3_end_time.getText().toString(),
                                et_project3_content.getText().toString());
                        editActivity.resumeInfo.getProjectInfos().add(projectInfo_3_1);
                        editActivity.resumeInfo.getProjectInfos().add(projectInfo_3_2);
                        editActivity.resumeInfo.getProjectInfos().add(projectInfo_3_3);
                        break;
                }
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
