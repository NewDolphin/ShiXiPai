package com.shixipai.ui.strategy.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.shixipai.R;
import com.shixipai.bean.strategy.StrategyItem;
import com.shixipai.ui.BaseActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by xiepeng on 16/2/6.
 */
public class StrategyDetailActivity extends AppCompatActivity {
    @Bind(R.id.toolbar_strategy_detail)
    Toolbar toolbar;

    @Bind(R.id.tv_strategy_detail_title)
    TextView tv_title;

    @Bind(R.id.tv_strategy_detail_time)
    TextView tv_time;

    @Bind(R.id.iv_strategy_detail)
    ImageView iv_pic;

    @Bind(R.id.tv_strategy_detail_content)
    TextView tv_content;

    private static final String PARAM_ID = "strategyItem";

    private StrategyItem strategyItem;

    public static void actionStart(Context context,StrategyItem strategyItem) {
        Intent intent = new Intent(context, StrategyDetailActivity.class);

        Bundle bundle = new Bundle();
        bundle.putSerializable(PARAM_ID, strategyItem);
        intent.putExtras(bundle);

        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strategy_detail);

        ButterKnife.bind(this);

        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        strategyItem = (StrategyItem)getIntent().getSerializableExtra(PARAM_ID);

        bindInfo(strategyItem);
    }

    private void bindInfo(StrategyItem strategyItem) {
        tv_title.setText(strategyItem.getTitle());
        tv_time.setText(strategyItem.getUpdated_at());
        Picasso.with(this)
                .load("http://182.92.11.218/i/shixipai/"+strategyItem.getImg())
                .into(iv_pic);
        tv_content.setText(strategyItem.getContent());
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
