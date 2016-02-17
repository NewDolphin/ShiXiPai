package com.shixipai.ui.edit.editinfo.want;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.shixipai.R;
import com.shixipai.bean.edit.ProjectInfo;
import com.shixipai.bean.edit.ResumeInfo;
import com.shixipai.bean.edit.WantInfo;
import com.shixipai.ui.edit.EditActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by xiepeng on 16/2/5.
 */
public class WantInfoFragment extends Fragment implements View.OnClickListener{
    public final static String PARAM_TYPE = "want_info";

    private ResumeInfo resumeInfo;

    private EditActivity editActivity;

    @Bind(R.id.et_scope)
    EditText et_scope;

    @Bind(R.id.et_job)
    EditText et_job;

    @Bind(R.id.et_city)
    EditText et_city;

    @Bind(R.id.et_money)
    EditText et_money;

    @Bind(R.id.et_extra)
    EditText et_extra;

    @Bind(R.id.bt_save)
    Button bt_save;

    public static WantInfoFragment getInstance(ResumeInfo resumeInfo){
        WantInfoFragment wantInfoFragment = new WantInfoFragment();

        Bundle bundle = new Bundle();
        bundle.putSerializable(PARAM_TYPE, resumeInfo);
        wantInfoFragment.setArguments(bundle);
        return wantInfoFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        resumeInfo = (ResumeInfo)getArguments().getSerializable(PARAM_TYPE);
        EditActivity editActivity = (EditActivity)getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_want_info,container,false);
        ButterKnife.bind(this, rootView);

        bindInfo();

        bindEvent();

        return rootView;
    }

    private void bindInfo() {
        et_scope.setText(resumeInfo.want_scope);
        et_job.setText(resumeInfo.want_job);
        et_city.setText(resumeInfo.want_area);
        et_money.setText(resumeInfo.want_salary);
        et_extra.setText(resumeInfo.add_info);
    }

    private void bindEvent() {
        bt_save.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_save:
                resumeInfo.want_scope = et_scope.getText().toString();
                resumeInfo.want_job = et_job.getText().toString();
                resumeInfo.want_area = et_city.getText().toString();
                resumeInfo.want_salary = et_money.getText().toString();
                resumeInfo.add_info = et_extra.getText().toString();
                break;
        }
    }
}
