package com.tale.taleframework.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tale.taleframework.R;
import com.tale.taleframework.core.ui.fragments.NetworkFragment;
import com.tale.taleframework.core.ui.widget.NoNetworkView;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Larry on 4/1/2015.
 */
public class TestNoNetworkFragment extends NetworkFragment {

    @InjectView(R.id.vNoNetwork) NoNetworkView vNoNetwork;
    @InjectView(R.id.lbContentView) TextView lbContentView;

    @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test_no_network, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override protected View getMainView() {
        return lbContentView;
    }

    @Override protected NoNetworkView getNoNetworkView() {
        return vNoNetwork;
    }

    @Override protected boolean isNetworkRequired() {
        return true;
    }

    private int count = 0;

    @Override protected boolean isNetworkConnected() {
        if (count == 0) {
            count++;
            return false;
        }
        return super.isNetworkConnected();
    }

    @Override public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
