package com.tale.taleframework.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.tale.mvp.model.ModelManager;
import com.tale.mvp.model.User;
import com.tale.mvp.presenter.UsersPresenter;
import com.tale.mvp.view.UsersView;
import com.tale.taleframework.R;
import com.tale.taleframework.adapter.UsersAdapter;
import com.tale.taleframework.core.ui.fragment.NetworkFragment;
import com.tale.taleframework.core.ui.widget.NoNetworkView;

import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Giang Nguyen on 4/2/2015.
 */
public class UsersFragment extends NetworkFragment implements UsersView{

    @InjectView(R.id.vNoNetwork)
    NoNetworkView vNoNetwork;
    @InjectView(R.id.vProgressBar)
    ProgressBar vProgressBar;
    @InjectView(R.id.rvUsers)
    RecyclerView rvUsers;

    @Inject
    UsersAdapter adapter;

    UsersPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_users, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    protected void onInjected() {
        super.onInjected();
        setupLoading(rvUsers, vProgressBar);
        rvUsers.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        rvUsers.setAdapter(adapter);
        presenter = new UsersPresenter(this, ModelManager.getGitUserModel());
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.onStop();
    }

    @Override
    protected View getMainView() {
        return rvUsers;
    }

    @Override
    protected NoNetworkView getNoNetworkView() {
        return vNoNetwork;
    }

    @Override
    protected boolean isNetworkRequired() {
        return true;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @Override
    public void showLoading(boolean show) {
        setShowLoading(show);
    }

    @Override
    public void render(List<User> users) {
        adapter.changeDataSet(users);
    }
}
