package com.shixipai.ui.resume;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.shixipai.R;
import com.shixipai.bean.edit.ResumeInfo;
import com.shixipai.ui.BaseFragment;
import com.shixipai.ui.edit.EditActivity;
import com.shixipai.ui.jobClassify.jobClassifyDetail.JobDetailModule;
import com.shixipai.ui.jobClassify.jobClassifyDetail.JobDetailPresenter;
import com.shixipai.ui.search.SearchActivity;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by xiepeng on 16/1/19.
 */
public class ResumeFragment extends BaseFragment implements ResumeView  {
    @Inject
    ResumePresenter presenter;

    @Bind(R.id.profile_image)
    CircleImageView profile_image;
    @Bind(R.id.tv_part1_empty)
    TextView tv_part1_empty;
    @Bind(R.id.tv_username)
    TextView tv_username;
    @Bind(R.id.tv_birthday)
    TextView tv_birthday;
    @Bind(R.id.tv_phone)
    TextView tv_phone;
    @Bind(R.id.tv_email)
    TextView tv_email;

    @Bind(R.id.tv_part2_empty)
    TextView tv_part2_empty;
    @Bind(R.id.part2_edu1)
    RelativeLayout part2_edu1;
    @Bind(R.id.tv_edu1_school)
    TextView tv_edu1_school;
    @Bind(R.id.tv_edu1_level)
    TextView tv_edu1_level;
    @Bind(R.id.tv_edu1_school_end_time)
    TextView tv_edu1_school_end_time;
    @Bind(R.id.tv_edu1_major)
    TextView tv_edu1_major;

    @Bind(R.id.part2_edu2)
    RelativeLayout part2_edu2;
    @Bind(R.id.tv_edu2_school)
    TextView tv_edu2_school;
    @Bind(R.id.tv_edu2_level)
    TextView tv_edu2_level;
    @Bind(R.id.tv_edu2_school_end_time)
    TextView tv_edu2_school_end_time;
    @Bind(R.id.tv_edu2_major)
    TextView tv_edu2_major;

    @Bind(R.id.part2_edu3)
    RelativeLayout part2_edu3;
    @Bind(R.id.tv_edu3_school)
    TextView tv_edu3_school;
    @Bind(R.id.tv_edu3_level)
    TextView tv_edu3_level;
    @Bind(R.id.tv_edu3_school_end_time)
    TextView tv_edu3_school_end_time;
    @Bind(R.id.tv_edu3_major)
    TextView tv_edu3_major;


    @Bind(R.id.tv_part3_empty)
    TextView tv_part3_empty;
    @Bind(R.id.part3_project1)
    RelativeLayout part3_project1;
    @Bind(R.id.tv_project1_title)
    TextView tv_project1_title;
    @Bind(R.id.tv_project1_start_time)
    TextView tv_project1_start_time;
    @Bind(R.id.tv_project1_end_time)
    TextView tv_project1_end_time;
    @Bind(R.id.tv_project1_content)
    TextView tv_project1_content;

    @Bind(R.id.part3_project2)
    RelativeLayout part3_project2;
    @Bind(R.id.tv_project2_title)
    TextView tv_project2_title;
    @Bind(R.id.tv_project2_start_time)
    TextView tv_project2_start_time;
    @Bind(R.id.tv_project2_end_time)
    TextView tv_project2_end_time;
    @Bind(R.id.tv_project2_content)
    TextView tv_project2_content;

    @Bind(R.id.part3_project3)
    RelativeLayout part3_project3;
    @Bind(R.id.tv_project3_title)
    TextView tv_project3_title;
    @Bind(R.id.tv_project3_start_time)
    TextView tv_project3_start_time;
    @Bind(R.id.tv_project3_end_time)
    TextView tv_project3_end_time;
    @Bind(R.id.tv_project3_content)
    TextView tv_project3_content;

    @Bind(R.id.tv_part4_empty)
    TextView tv_part4_empty;
    @Bind(R.id.tv_want_scope)
    TextView tv_want_scope;
    @Bind(R.id.tv_want_job)
    TextView tv_want_job;
    @Bind(R.id.tv_want_city)
    TextView tv_want_city;
    @Bind(R.id.tv_want_money)
    TextView tv_want_money;
    @Bind(R.id.tv_want_extra)
    TextView tv_want_extra;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_resume, container, false);
        ButterKnife.bind(this, view);

        setHasOptionsMenu(true);

        showProgress();

        presenter.loadData();

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_resume, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_edit:
                EditActivity.actionStart(getActivity());
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected List<Object> getModules() {
        return Arrays.<Object>asList(new ResumeModule(this));
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void addData(ResumeInfo resumeInfo) {
        if (resumeInfo.name==null&&resumeInfo.birthday==null&resumeInfo.mail==null&&resumeInfo.phone==null){
            tv_part1_empty.setVisibility(View.VISIBLE);
        }
        if (resumeInfo.name != null){
            tv_username.setText(resumeInfo.name);
            tv_username.setVisibility(View.VISIBLE);
        }
        if (resumeInfo.birthday != null){
            tv_birthday.setText(resumeInfo.birthday);
            tv_birthday.setVisibility(View.VISIBLE);
        }
        if (resumeInfo.mail != null){
            tv_email.setText(resumeInfo.mail);
            tv_email.setVisibility(View.VISIBLE);
        }
        if (resumeInfo.phone != null){
            tv_phone.setText(resumeInfo.phone);
            tv_phone.setVisibility(View.VISIBLE);
        }



        if (resumeInfo.school_1 == null){
            tv_part2_empty.setVisibility(View.VISIBLE);
        }else {
            part2_edu1.setVisibility(View.VISIBLE);
            tv_edu1_school.setText(resumeInfo.school_1);
            tv_edu1_school_end_time.setText(resumeInfo.graduated_time_1);
            tv_edu1_level.setText(resumeInfo.grade_1);
            tv_edu1_major.setText(resumeInfo.professional_1);
        }
        if (resumeInfo.school_2 != null){
            part2_edu2.setVisibility(View.VISIBLE);
            tv_edu2_school.setText(resumeInfo.school_2);
            tv_edu2_school_end_time.setText(resumeInfo.graduated_time_2);
            tv_edu2_level.setText(resumeInfo.grade_2);
            tv_edu2_major.setText(resumeInfo.professional_2);
        }
        if (resumeInfo.school_3 != null){
            part2_edu3.setVisibility(View.VISIBLE);
            tv_edu3_school.setText(resumeInfo.school_3);
            tv_edu3_school_end_time.setText(resumeInfo.graduated_time_3);
            tv_edu3_level.setText(resumeInfo.grade_3);
            tv_edu3_major.setText(resumeInfo.professional_3);
        }



        if (resumeInfo.project_title_1 == null){
            tv_part3_empty.setVisibility(View.VISIBLE);
        }else {
            part3_project1.setVisibility(View.VISIBLE);
            tv_project1_title.setText(resumeInfo.project_title_1);
            tv_project1_start_time.setText(resumeInfo.project_start_1+" --");
            tv_project1_end_time.setText(resumeInfo.project_end_1);
            tv_project1_content.setText(resumeInfo.project_job_1);
        }
        if (resumeInfo.project_title_2 != null){
            part3_project2.setVisibility(View.VISIBLE);
            tv_project2_title.setText(resumeInfo.project_title_2);
            tv_project2_start_time.setText(resumeInfo.project_start_2+" --");
            tv_project2_end_time.setText(resumeInfo.project_end_2);
            tv_project2_content.setText(resumeInfo.project_job_2);
        }
        if (resumeInfo.project_title_3 != null){
            part3_project3.setVisibility(View.VISIBLE);
            tv_project3_title.setText(resumeInfo.project_title_3);
            tv_project3_start_time.setText(resumeInfo.project_start_3+" --");
            tv_project3_end_time.setText(resumeInfo.project_end_3);
            tv_project3_content.setText(resumeInfo.project_job_3);
        }


        if (tv_want_scope==null&&tv_want_job==null&&tv_want_city==null&&tv_want_money==null&&tv_want_extra==null){
            tv_part4_empty.setVisibility(View.VISIBLE);
        }
        if (resumeInfo.want_scope != null){
            tv_want_scope.setText(resumeInfo.want_scope);
            tv_want_scope.setVisibility(View.VISIBLE);
        }
        if (resumeInfo.want_job != null){
            tv_want_job.setText(resumeInfo.want_job);
            tv_want_job.setVisibility(View.VISIBLE);
        }
        if (resumeInfo.want_area != null){
            tv_want_city.setText(resumeInfo.want_area);
            tv_want_city.setVisibility(View.VISIBLE);
        }
        if (resumeInfo.want_salary != null){
            tv_want_money.setText(resumeInfo.want_salary);
            tv_want_money.setVisibility(View.VISIBLE);
        }
        if (resumeInfo.add_info != null){
            tv_want_extra.setText(resumeInfo.add_info);
            tv_want_extra.setVisibility(View.VISIBLE);
        }
    }
}
