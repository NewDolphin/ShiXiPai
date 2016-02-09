package com.shixipai.ui.edit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.shixipai.R;
import com.shixipai.bean.edit.ResumeInfo;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by xiepeng on 16/2/5.
 */
public class EditActivity extends AppCompatActivity{
    @Bind(R.id.toolbar_edit)
    Toolbar toolbar;

    @Bind(R.id.viewpager_edit)
    public ViewPager viewPager;

    public ResumeInfo resumeInfo;

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, EditActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actiivty_edit);

        ButterKnife.bind(this);

        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        resumeInfo = new ResumeInfo();

        FragmentPagerAdapter fragmentPagerAdapter = new EditAdapter(getSupportFragmentManager(),resumeInfo);
        viewPager.setAdapter(fragmentPagerAdapter);
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
