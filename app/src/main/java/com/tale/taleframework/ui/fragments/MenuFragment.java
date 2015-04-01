package com.tale.taleframework.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tale.taleframework.R;
import com.tale.taleframework.core.ui.fragments.BaseFragment;
import com.tale.taleframework.mvp.presenter.MenuPresenter;

import javax.inject.Inject;

import butterknife.OnClick;

/**
 * Created by Larry on 4/1/2015.
 */
public class MenuFragment extends BaseFragment {

    @Inject MenuPresenter menuPresenter;

    @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @OnClick(R.id.btLoading) public void onLoadingClicked() {
        menuPresenter.onLoadingClicked();
    }

    @OnClick(R.id.btTestNoNetwork) public void onTestNoNetworkClicked() {
        menuPresenter.onTestNoNetworkClicked();
    }

}
