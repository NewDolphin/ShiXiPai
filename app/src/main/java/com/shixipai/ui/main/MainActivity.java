package com.shixipai.ui.main;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.holder.BadgeStyle;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import com.shixipai.R;
import com.shixipai.support.PrefUtils;
import com.shixipai.support.ResourceHelper;
import com.shixipai.ui.BaseActivity;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by xiepeng on 16/1/13.
 */
public class MainActivity extends BaseActivity implements MainView{

    private static final String[] DRAWER_TITLES = ResourceHelper.getStringArrays(R.array.drawer_list_items);

    @Inject
    MainPresenter mMainPresenter;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    private AccountHeader mHeaderResult = null;
    private Drawer mResult = null;

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mContext = this;

        setSupportActionBar(toolbar);
        initialDrawer(savedInstanceState);

        ButterKnife.bind(this);
    }

    private void initialDrawer(Bundle savedInstanceState){
        final IProfile profile = new ProfileDrawerItem()
                .withName(PrefUtils.getPrefUsername())
                .withIcon(ResourceHelper.getDrawable(R.mipmap.ic_launcher))
                .withIdentifier(100);

        mHeaderResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.mipmap.header)
                .withSelectionListEnabled(false)
                .addProfiles(profile)
                .withOnlyMainProfileImageVisible(true)
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean current) {
//                        ProfileActivity.actionStart(mContext, PrefUtils.getPrefUid());
                        return false;
                    }
                })
                .withOnAccountHeaderSelectionViewClickListener(new AccountHeader.OnAccountHeaderSelectionViewClickListener() {
                    @Override
                    public boolean onClick(View view, IProfile profile) {
                        mResult.closeDrawer();
//                        ProfileActivity.actionStart(mContext, PrefUtils.getPrefUid());
                        return false;
                    }
                })
                .withSavedInstance(savedInstanceState)
                .build();
        mResult = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withHasStableIds(true)
                .withStatusBarColor(ResourceHelper.getColor(R.color.color_accent_dark))
                .withAccountHeader(mHeaderResult)
                .addDrawerItems(
                        new PrimaryDrawerItem()
                                .withName(R.string.drawer_item_setting)
                                .withIcon(R.mipmap.ic_drawer_setting)
                                .withIdentifier(1).withSelectable(true)
                                .withSelectedTextColor(ResourceHelper.getColor(R.color.color_primary))

                        , new PrimaryDrawerItem()
                                .withName(R.string.drawer_item_share)
                                .withIcon(R.mipmap.ic_drawer_share)
                                .withIdentifier(2).withSelectable(true)
                                .withSelectedTextColor(ResourceHelper.getColor(R.color.color_primary))

                        , new PrimaryDrawerItem()
                                .withName(R.string.drawer_item_feedback)
                                .withIcon(R.mipmap.ic_drawer_feedback)
                                .withIdentifier(3).withSelectable(true)
                                .withSelectedTextColor(ResourceHelper.getColor(R.color.color_primary))

                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                                                   @Override
                                                   public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                                                       if (drawerItem != null) {
                                                           mMainPresenter.selectDrawerItem(drawerItem.getIdentifier());
                                                       }
                                                       return false;
                                                   }
                                               }

                )
                .withSavedInstance(savedInstanceState)

                .withShowDrawerOnFirstLaunch(true)
                .build();
        if(savedInstanceState == null){
            mResult.setSelection(1,false);
            mHeaderResult.setActiveProfile(profile);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

//        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

//        switch (item.getItemId()){
//            case android.R.id.home:
////                mDrawerLayout.openDrawer(GravityCompat.START);
//                return true;
//            case R.id.action_search:
//                SearchActivity.actionStart(this);
//                return true;
//            case R.id.action_create_question:
//                startActivity(new Intent(this, PublishActivity.class));
//                break;
//        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(mResult.isDrawerOpen()){
            mResult.closeDrawer();
            return true;
        }
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
//            if (System.currentTimeMillis() - exitTime > 2000) {
//                Toast.makeText(this, getString(R.string.quit), Toast.LENGTH_SHORT).show();
//                exitTime = System.currentTimeMillis();
//            } else {
//                finish();
//                System.exit(0);
//            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected List<Object> getModules() {
        return Arrays.<Object>asList(new MainModule(this));
    }


    @Override
    public void replaceFragment(int position) {

    }

    @Override
    public void startSettingsActivity() {

    }

    @Override
    public void startFeedbackActivity() {

    }

    @Override
    public void shareApp() {

    }

}
