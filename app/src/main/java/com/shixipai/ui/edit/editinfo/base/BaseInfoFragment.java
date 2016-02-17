package com.shixipai.ui.edit.editinfo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.shixipai.R;
import com.shixipai.bean.edit.BaseInfo;
import com.shixipai.bean.edit.ResumeInfo;
import com.shixipai.ui.BaseFragment;
import com.shixipai.ui.common.edit.SelectPhotoDialogFragment;
import com.shixipai.ui.edit.EditActivity;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by xiepeng on 16/2/5.
 */
public class BaseInfoFragment extends Fragment implements View.OnClickListener, DatePickerDialog.OnDateSetListener {
    public final static String PARAM_TYPE = "base_info";

    private ResumeInfo resumeInfo;

    private EditActivity editActivity;

    @Bind(R.id.img_person)
    CircleImageView img_person;

    @Bind(R.id.et_name)
    EditText et_name;

    @Bind(R.id.radio_group)
    RadioGroup radioGroup;

    @Bind(R.id.radio_bt_male)
    RadioButton radio_bt_male;

    @Bind(R.id.radio_bt_female)
    RadioButton radio_bt_female;

    @Bind(R.id.layout_base_birthday)
    LinearLayout layout_base_birthday;

    @Bind(R.id.tv_birthday)
    TextView tv_birthday;

    @Bind(R.id.et_telphone)
    EditText et_telphone;

    @Bind(R.id.et_email)
    EditText et_email;

    @Bind(R.id.bt_modify_img)
    Button bt_modify_img;

    @Bind(R.id.bt_next)
    Button bt_next;


    public static BaseInfoFragment getInstance(ResumeInfo resumeInfo){
        BaseInfoFragment baseInfoFragment = new BaseInfoFragment();

        Bundle bundle = new Bundle();
        bundle.putSerializable(PARAM_TYPE, resumeInfo);
        baseInfoFragment.setArguments(bundle);
        return baseInfoFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        resumeInfo = (ResumeInfo)getArguments().getSerializable(PARAM_TYPE);
        EditActivity editActivity = (EditActivity)getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_base_info,container,false);
        ButterKnife.bind(this, rootView);

        bindInfo();

        bindEvent();

        return rootView;
    }

    private void bindInfo() {
        et_name.setText(resumeInfo.name);
        if (resumeInfo.sex.equals("男")){
            radio_bt_male.setChecked(true);
        }else if (resumeInfo.sex.equals("女")){
            radio_bt_female.setChecked(true);
        }
        tv_birthday.setText(resumeInfo.birthday);
        et_telphone.setText(resumeInfo.phone);
        et_email.setText(resumeInfo.mail);
    }

    private void bindEvent() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == radio_bt_male.getId()) {
                    editActivity.resumeInfo.sex = "男";
                } else if (checkedId == radio_bt_female.getId()) {
                    editActivity.resumeInfo.sex = "女";
                }
            }
        });
        layout_base_birthday.setOnClickListener(this);
        bt_modify_img.setOnClickListener(this);
        bt_next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.layout_base_birthday:
                Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        BaseInfoFragment.this,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );
                dpd.showYearPickerFirst(true);
                dpd.show(getActivity().getFragmentManager(), "Datepickerdialog");
                break;
            case R.id.bt_modify_img:
//                new SelectPhotoDialogFragment().show(editActivity);
//                break;
            case R.id.bt_next:
                editActivity.resumeInfo.name = et_name.getText().toString();
                editActivity.resumeInfo.birthday = tv_birthday.getText().toString();
                editActivity.resumeInfo.phone = et_telphone.getText().toString();
                editActivity.resumeInfo.mail = et_email.getText().toString();

                editActivity.viewPager.setCurrentItem(1);
                break;
        }
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        String dateContent = dayOfMonth+"/"+(++monthOfYear)+"/"+year;
        tv_birthday.setText(dateContent);
    }
}
