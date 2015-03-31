package com.tale.taleframework.core.ui.views;

import android.view.View;

public class ViewSwitcher {

    private View mainView;
    private View alterView;
    private boolean isMainShowing = true;

    public void showMainView(boolean show) {
        if (isMainShowing == show) {
            return;
        }
        isMainShowing = show;
        if (mainView != null) {
            mainView.setVisibility(show ? View.VISIBLE : View.GONE);
        }
        if (alterView != null) {
            alterView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }

    public void setMainView(View mainView) {
        this.mainView = mainView;
    }

    public void setAlterView(View alterView) {
        this.alterView = alterView;
    }
}
