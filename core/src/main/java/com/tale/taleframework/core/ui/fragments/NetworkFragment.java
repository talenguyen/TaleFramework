package com.tale.taleframework.core.ui.fragments;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;

import com.tale.taleframework.core.ui.views.ViewSwitcher;
import com.tale.taleframework.core.ui.widget.NoNetworkView;

/**
 * Created by Larry on 3/31/2015.
 */
public abstract class NetworkFragment extends LoadingFragment {

    private ViewSwitcher noNetworkViewSwitcher;
    private View.OnClickListener retryClickListener;

    protected abstract View getMainView();

    protected abstract NoNetworkView getNoNetworkView();

    protected abstract boolean isNetworkRequired();

    @Override
    public void onResume() {
        super.onResume();
        if (isNetworkRequired()) {
            checkNetworkConnection();
        }
    }

    protected void checkNetworkConnection() {
        if (!isNetworkConnected()) {
            if (noNetworkViewSwitcher == null) {
                final View noNetworkView = getNoNetworkView();
                if (noNetworkView == null) {
                    return;
                }
                final View mainView = getMainView();
                noNetworkViewSwitcher = new ViewSwitcher();
                noNetworkViewSwitcher.setAlterView(noNetworkView);
                noNetworkViewSwitcher.setMainView(mainView);
                if (retryClickListener == null) {
                    retryClickListener = new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            checkNetworkConnection();
                        }
                    };
                }
                ((NoNetworkView) noNetworkView).getIconView().setOnClickListener
                    (retryClickListener);
            }
            if (noNetworkViewSwitcher != null) {
                noNetworkViewSwitcher.showMainView(false);
            }
        } else {
            if (noNetworkViewSwitcher != null) {
                noNetworkViewSwitcher.showMainView(true);
            }
        }
    }

    protected boolean isNetworkConnected() {
        ConnectivityManager cm =
            (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null &&
                              activeNetwork.isConnected();
    }

}
