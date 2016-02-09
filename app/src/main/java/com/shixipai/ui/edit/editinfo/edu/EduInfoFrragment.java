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
import android.widget.Toast;

import com.shixipai.R;
import com.shixipai.bean.edit.BaseInfo;
import com.shixipai.bean.edit.EduInfo;
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

    private ArrayList<EduInfo> eduInfos = new ArrayList<EduInfo>();

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

    public static EduInfoFrragment getInstance(ArrayList<EduInfo> eduInfos){
        EduInfoFrragment eduInfoFrragment = new EduInfoFrragment();

        Bundle bundle = new Bundle();
        bundle.putSerializable(PARAM_TYPE, eduInfos);
        eduInfoFrragment.setArguments(bundle);
        return eduInfoFrragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        eduInfos = (ArrayList<EduInfo>)getArguments().getSerializable(PARAM_TYPE);
        EditActivity editActivity = (EditActivity)getActivity();
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
        switch(eduInfos.size()){
            case 0:
                eduCount = 1;
                break;
            case 1:
                eduCount = 1;
                tv_edu1_end_time.setText(eduInfos.get(0).getEnd_time());
                et_edu1_school.setText(eduInfos.get(0).getSchool());
                et_edu1_level.setText(eduInfos.get(0).getLevel());
                et_edu1_major.setText(eduInfos.get(0).getMajor());
                break;
            case 2:
                eduCount = 2;
                tv_edu1_end_time.setText(eduInfos.get(0).getEnd_time());
                et_edu1_school.setText(eduInfos.get(0).getSchool());
                et_edu1_level.setText(eduInfos.get(0).getLevel());
                et_edu1_major.setText(eduInfos.get(0).getMajor());

                tv_edu2_end_time.setText(eduInfos.get(1).getEnd_time());
                et_edu2_school.setText(eduInfos.get(1).getSchool());
                et_edu2_level.setText(eduInfos.get(1).getLevel());
                et_edu2_major.setText(eduInfos.get(1).getMajor());

                layout_edu2.setVisibility(View.VISIBLE);
                break;
            case 3:
                eduCount = 3;
                tv_edu1_end_time.setText(eduInfos.get(0).getEnd_time());
                et_edu1_school.setText(eduInfos.get(0).getSchool());
                et_edu1_level.setText(eduInfos.get(0).getLevel());
                et_edu1_major.setText(eduInfos.get(0).getMajor());

                tv_edu2_end_time.setText(eduInfos.get(1).getEnd_time());
                et_edu2_school.setText(eduInfos.get(1).getSchool());
                et_edu2_level.setText(eduInfos.get(1).getLevel());
                et_edu2_major.setText(eduInfos.get(1).getMajor());

                tv_edu3_end_time.setText(eduInfos.get(2).getEnd_time());
                et_edu3_school.setText(eduInfos.get(2).getSchool());
                et_edu3_level.setText(eduInfos.get(2).getLevel());
                et_edu3_major.setText(eduInfos.get(2).getMajor());

                layout_edu2.setVisibility(View.VISIBLE);
                layout_edu3.setVisibility(View.VISIBLE);
                break;
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
                if (eduCount == 1){
                    layout_edu2.setVisibility(View.VISIBLE);
                }else if (eduCount == 2){
                    layout_edu3.setVisibility(View.VISIBLE);
                }else {
                    Toast.makeText(getActivity(),"最多添加三条记录",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.bt_next:
                editActivity.resumeInfo.getEduInfos().clear();
                switch (eduCount){
                    case 1:
                        EduInfo eduInfo_1_1 = new EduInfo(et_edu1_school.getText().toString(),
                                et_edu1_level.getText().toString(),
                                tv_edu1_end_time.getText().toString(),
                                et_edu1_major.getText().toString());
                        editActivity.resumeInfo.getEduInfos().add(eduInfo_1_1);
                        break;
                    case 2:
                        EduInfo eduInfo_2_1 = new EduInfo(et_edu1_school.getText().toString(),
                                et_edu1_level.getText().toString(),
                                tv_edu1_end_time.getText().toString(),
                                et_edu1_major.getText().toString());
                        EduInfo eduInfo_2_2 = new EduInfo(et_edu2_school.getText().toString(),
                                et_edu2_level.getText().toString(),
                                tv_edu2_end_time.getText().toString(),
                                et_edu2_major.getText().toString());
                        editActivity.resumeInfo.getEduInfos().add(eduInfo_2_1);
                        editActivity.resumeInfo.getEduInfos().add(eduInfo_2_2);
                        break;
                    case 3:
                        EduInfo eduInfo_3_1 = new EduInfo(et_edu1_school.getText().toString(),
                                et_edu1_level.getText().toString(),
                                tv_edu1_end_time.getText().toString(),
                                et_edu1_major.getText().toString());
                        EduInfo eduInfo_3_2 = new EduInfo(et_edu2_school.getText().toString(),
                                et_edu2_level.getText().toString(),
                                tv_edu2_end_time.getText().toString(),
                                et_edu2_major.getText().toString());
                        EduInfo eduInfo_3_3 = new EduInfo(et_edu3_school.getText().toString(),
                                et_edu3_level.getText().toString(),
                                tv_edu3_end_time.getText().toString(),
                                et_edu3_major.getText().toString());
                        editActivity.resumeInfo.getEduInfos().add(eduInfo_3_1);
                        editActivity.resumeInfo.getEduInfos().add(eduInfo_3_2);
                        editActivity.resumeInfo.getEduInfos().add(eduInfo_3_3);
                        break;
                }
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
