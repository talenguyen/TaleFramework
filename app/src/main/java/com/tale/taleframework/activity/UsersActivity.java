package com.tale.taleframework.activity;

import android.os.Bundle;

import com.squareup.otto.Subscribe;
import com.tale.mvp.model.User;
import com.tale.taleframework.R;
import com.tale.taleframework.core.ui.FragmentNavigator;
import com.tale.taleframework.core.ui.activity.BaseActivity;
import com.tale.taleframework.fragment.UserDetailFragment;
import com.tale.taleframework.fragment.UsersFragment;
import com.tale.taleframework.module.users.UsersModule;
import com.tale.taleframework.util.EventBus;

import javax.inject.Inject;

/**
 * Created by Giang Nguyen on 4/2/2015.
 */
public class UsersActivity extends BaseActivity {
    private FragmentNavigator fragmentNavigator;

    @Inject
    EventBus bus;

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
    protected void onResume() {
        super.onResume();
        bus.register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        bus.unregister(this);
    }

    @Override
    public void onBackPressed() {
        if(!fragmentNavigator.navigateBack()) super.onBackPressed();
    }

    @Subscribe
    public void onUserItemClicked(User user) {
        fragmentNavigator.showScreen(UserDetailFragment.newInstance(user.login), true);
    }

    @Override
    protected Object[] getModules() {
        return new Object[]{new UsersModule(this)};
    }
}
