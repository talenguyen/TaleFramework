package com.tale.taleframework.ui.activities;

import android.os.Bundle;

import com.tale.taleframework.R;
import com.tale.taleframework.core.ui.FragmentNavigator;
import com.tale.taleframework.core.ui.activities.BaseActivity;
import com.tale.taleframework.mvp.presenter.MenuPresenter;
import com.tale.taleframework.ui.fragments.MenuFragment;
import com.tale.taleframework.ui.fragments.TestLoadingFragment;
import com.tale.taleframework.ui.fragments.TestNoNetworkFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Larry on 3/31/2015.
 */
public class TestFragmentActivity extends BaseActivity implements MenuPresenter {

    private FragmentNavigator fragmentNavigator;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_single_page;
    }

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentNavigator = FragmentNavigator.create(this, R.id.container);
        if (savedInstanceState == null) {
            fragmentNavigator.showScreen(new MenuFragment(), false);
        }
    }

    @Override public void onLoadingClicked() {
        fragmentNavigator.showScreen(new TestLoadingFragment(), true);
    }

    @Override public void onTestNoNetworkClicked() {
        fragmentNavigator.showScreen(new TestNoNetworkFragment(), true);
    }

    @Override protected Object[] getModules() {
        return new Object[]{new TestFragmentModule(this)};
    }

    @Override public void onBackPressed() {
        if(!fragmentNavigator.navigateBack()) super.onBackPressed();
    }

    @Module(
            injects = {
                TestFragmentActivity.class,
                MenuFragment.class,
                TestLoadingFragment.class,
                TestNoNetworkFragment.class
            },
            complete = false
    )
    public static class TestFragmentModule {

        private final TestFragmentActivity activity;

        public TestFragmentModule(TestFragmentActivity activity) {
            this.activity = activity;
        }

        @Provides public MenuPresenter provideMenuPresenter() {
            return activity;
        }
    }
}
