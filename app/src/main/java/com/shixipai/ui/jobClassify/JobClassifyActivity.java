package com.shixipai.ui.jobClassify;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.shixipai.R;
import com.shixipai.bean.JobClassifyItem;
import com.shixipai.ui.common.OnItemClickListener;
import com.shixipai.ui.jobClassify.jobClassifyList.JobClassifyListActivity;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by xiepeng on 16/1/23.
 */
//没有再分一层presenter，因为功能逻辑简单
public class JobClassifyActivity extends AppCompatActivity implements OnItemClickListener {

    @Bind(R.id.toolbar_job_classify)
    Toolbar toolbar;

    @Bind(R.id.job_classify_recycler_view)
    RecyclerView recyclerView;

    private ArrayList<JobClassifyItem> datas = new ArrayList<JobClassifyItem>();

    private JobClassifyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_classify);
        ButterKnife.bind(this);

        initData();

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));

    }

    private void initData() {
        datas.add(new JobClassifyItem("互联网", R.mipmap.ic_job_kind1));
        datas.add(new JobClassifyItem("金融/法律",R.mipmap.ic_job_kind2));
        datas.add(new JobClassifyItem("建设工程",R.mipmap.ic_job_kind3));
        datas.add(new JobClassifyItem("销售/推广",R.mipmap.ic_job_kind4));
        datas.add(new JobClassifyItem("人力资源/产品", R.mipmap.ic_job_kind5));
        datas.add(new JobClassifyItem("汽车/制造", R.mipmap.ic_job_kind6));
        datas.add(new JobClassifyItem("文化/传媒", R.mipmap.ic_job_kind7));
        datas.add(new JobClassifyItem("教育//医疗", R.mipmap.ic_job_kind8));
        datas.add(new JobClassifyItem("文案/管理", R.mipmap.ic_job_kind9));

        adapter = new JobClassifyAdapter(datas,this);
    }

    @Override
    public void onItemClicked(View view, int position) {
        switch (view.getId()) {
            case R.id.pic_job_classify:
                startJobClassifyListActivity(position);
                break;
            case R.id.title_job_classify:
                startJobClassifyListActivity(position);
                break;
        }
    }

    private void startJobClassifyListActivity(int postion){
        Intent intent = new Intent(this, JobClassifyListActivity.class);
        intent.putExtra("tag",postion);
        startActivity(intent);
    }

}
