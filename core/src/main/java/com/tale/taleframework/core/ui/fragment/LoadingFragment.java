package com.tale.taleframework.core.ui.fragment;

import android.view.View;

import com.tale.taleframework.core.ui.view.ViewSwitcher;

/**
 * Created by Larry on 3/31/2015.
 */
public class LoadingFragment extends BaseFragment {

    private ViewSwitcher loadingViewSwitcher;

    protected void setupLoading(View mainView, View loadingView) {
        loadingViewSwitcher = new ViewSwitcher();
        loadingViewSwitcher.setMainView(mainView);
        loadingViewSwitcher.setAlterView(loadingView);
    }

    public void setShowLoading(boolean show) {
        loadingViewSwitcher.showMainView(!show);
    }

}
