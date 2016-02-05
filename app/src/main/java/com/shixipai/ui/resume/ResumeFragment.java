package com.shixipai.ui.resume;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.shixipai.R;
import com.shixipai.ui.BaseFragment;
import com.shixipai.ui.edit.EditActivity;
import com.shixipai.ui.search.SearchActivity;

import java.util.List;

/**
 * Created by xiepeng on 16/1/19.
 */
public class ResumeFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_resume, container, false);

        setHasOptionsMenu(true);

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

//    @Override
//    protected List<Object> getModules() {
//        return null;
//    }
}
