package com.shixipai.ui.jobClassify.jobClassifyDetail;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.shixipai.R;
import com.shixipai.bean.JobDetail;
import com.shixipai.ui.BaseActivity;
import com.shixipai.ui.jobClassify.jobClassifyList.JobClassifyListModule;
import com.squareup.picasso.Picasso;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by xiepeng on 16/1/23.
 */
public class JobClassifyDetailActivity extends BaseActivity implements JobDetailView{
    @Inject
    JobDetailPresenter presenter;

    @Bind(R.id.job_detail_toolbar)
    Toolbar toolbar;

    @Bind(R.id.img_job_classify_detail)
    ImageView img_company;

    @Bind(R.id.tv_job_detail_title)
    TextView tv_job_title;

    @Bind(R.id.tv_job_detail_company)
    TextView tv_job_company;

    @Bind(R.id.tv_job_detail_area)
    TextView tv_job_area;

    @Bind(R.id.tv_job_detail_salary)
    TextView tv_job_salary;

    @Bind(R.id.tv_job_detail_edu)
    TextView tv_job_edu;

    @Bind(R.id.tv_job_detail_html)
    TextView tv_job_html;

    @Bind(R.id.pb_job_detail)
    ProgressBar progressBar;

    @Bind(R.id.sv_job_detail)
    ScrollView sv_content;

    @Bind(R.id.layout_job_detail_send)
    LinearLayout layout_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_classify_detail);

        ButterKnife.bind(this);

        initToolBar();

        int id = getIntent().getIntExtra("id",0);

        showProgress();

        presenter.loadData(id);

    }

    private void initToolBar() {
        toolbar.setTitle("职位详情");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
    }

    @Override
    protected List<Object> getModules() {
        return Arrays.<Object>asList(new JobDetailModule(this));
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        sv_content.setVisibility(View.INVISIBLE);
        layout_send.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
        layout_send.setVisibility(View.VISIBLE);
        sv_content.setVisibility(View.VISIBLE);
    }

    @Override
    public void addData(JobDetail jobDetail) {
        Picasso.with(this)
                .load(jobDetail.getCompany_image())
                .into(img_company);
        tv_job_title.setText(jobDetail.getTitle());
        tv_job_company.setText(jobDetail.getCompany());
        tv_job_area.setText(jobDetail.getArea());
        tv_job_salary.setText(jobDetail.getSalary());
        tv_job_edu.setText(jobDetail.getEducation());
        tv_job_html.setText(Html.fromHtml(jobDetail.getInfo()));

        hideProgress();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
