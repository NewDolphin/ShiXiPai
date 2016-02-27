package com.shixipai.ui.main;


/**
 * Created by xiepeng on 16/1/19.
 */
public class MainPresenterImpl implements MainPresenter {

    private MainView mMainView;

    public MainPresenterImpl(MainView MainView) {
        this.mMainView = MainView;
    }


    @Override
    public void selectBottomItem(int position) {

    }

    @Override
    public void selectDrawerItem(int position) {
        if (position == 1) {
            mMainView.startSettingsActivity();
        } else if (position == 2) {
            mMainView.shareApp();
        } else if (position == 3) {
            mMainView.startFeedbackActivity();
        } else if (position == 4){
            mMainView.startCollectActivity();
        }
    }
}
