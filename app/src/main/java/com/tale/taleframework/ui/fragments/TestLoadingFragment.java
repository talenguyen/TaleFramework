package com.tale.taleframework.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.tale.taleframework.R;
import com.tale.taleframework.core.ui.fragments.LoadingFragment;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by Larry on 4/1/2015.
 */
public class TestLoadingFragment extends LoadingFragment {

    @InjectView(R.id.progressBar) ProgressBar progressBar;
    @InjectView(R.id.btHideLoading) Button btHideLoading;
    @InjectView(R.id.vgMainContent) LinearLayout vgMainContent;

    @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test_loading, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override protected void onInjected() {
        super.onInjected();
        setupLoading(vgMainContent, progressBar);
    }

    @OnClick(R.id.btShowLoading) public void showLoading() {
        setShowLoading(true);
        btHideLoading.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.btHideLoading) public void hideLoading() {
        setShowLoading(false);
        btHideLoading.setVisibility(View.GONE);
    }

    @Override public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
