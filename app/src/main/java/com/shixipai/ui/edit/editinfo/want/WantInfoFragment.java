package com.shixipai.ui.edit.editinfo.want;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.shixipai.R;
import com.shixipai.bean.edit.ResumeInfo;
import com.shixipai.ui.BaseFragment;
import com.shixipai.ui.edit.EditActivity;
import com.shixipai.ui.resume.ResumeModule;
import com.shixipai.ui.resume.ResumePresenter;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by xiepeng on 16/2/5.
 */
public class WantInfoFragment extends BaseFragment implements View.OnClickListener,WantView{
    @Inject
    PostResumePresenter presenter;

    public final static String PARAM_TYPE = "want_info";

    private ResumeInfo resumeInfo;

    private EditActivity editActivity;

    private boolean showDialog = false;

    private MaterialDialog dialog;

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
        editActivity = (EditActivity)getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_want_info,container,false);
        ButterKnife.bind(this, rootView);

        bindInfo();

        bindEvent();

        dialog = createDialog().build();

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
                editActivity.resumeInfo.want_scope = et_scope.getText().toString();
                editActivity.resumeInfo.want_job = et_job.getText().toString();
                editActivity.resumeInfo.want_area = et_city.getText().toString();
                editActivity.resumeInfo.want_salary = et_money.getText().toString();
                editActivity.resumeInfo.add_info = et_extra.getText().toString();

                showDialog = true;
                dialog.show();

                presenter.postResume(editActivity.resumeInfo);
                break;
        }
    }

    private MaterialDialog.Builder createDialog(){
        MaterialDialog.Builder builder = new MaterialDialog.Builder(getActivity())
                .title("正在上传信息")
                .content("请稍等")
                .negativeText("取消")
                .onNegative(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(MaterialDialog dialog, DialogAction which) {
                        Toast.makeText(getActivity(),"cancel",Toast.LENGTH_SHORT).show();
                    }
                })
                .progress(true, 0)
                .cancelable(false)
                .progressIndeterminateStyle(false); //false表示不是horizontal

        return builder;
    }

    @Override
    protected List<Object> getModules() {
        return Arrays.<Object>asList(new PostResumeModule(this));
    }

    @Override
    public void postResult(boolean result) {
        if (result){

            if (showDialog){
                dialog.dismiss();
                getActivity().finish();
                Toast.makeText(getActivity(),"信息上传成功",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
