package com.tale.taleframework.activity;

import android.os.Bundle;

import com.tale.taleframework.R;
import com.tale.taleframework.core.ui.FragmentNavigator;
import com.tale.taleframework.core.ui.activity.BaseActivity;
import com.tale.taleframework.fragment.UsersFragment;
import com.tale.taleframework.module.users.UsersModule;

/**
 * Created by Giang Nguyen on 4/2/2015.
 */
public class UsersActivity extends BaseActivity {
    private FragmentNavigator fragmentNavigator;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_single_page;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentNavigator = FragmentNavigator.create(this, R.id.container);
        if (savedInstanceState == null) {
            fragmentNavigator.showScreen(new UsersFragment(), false);
        }
    }

    @Override
    protected Object[] getModules() {
        return new Object[]{new UsersModule(this)};
    }
}
