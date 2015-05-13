package com.tale.taleframework.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.tale.mvp.model.ModelManager;
import com.tale.mvp.model.User;
import com.tale.mvp.presenter.UserDetailPresenter;
import com.tale.mvp.view.UserDetailView;
import com.tale.taleframework.R;
import com.tale.taleframework.activity.UsersActivity;
import com.tale.taleframework.core.ui.fragment.NetworkFragment;
import com.tale.taleframework.core.ui.widget.NoNetworkView;
import com.tale.taleframework.util.ImageLoader;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Giang Nguyen on 4/2/2015.
 */
public class UserDetailFragment extends NetworkFragment implements UserDetailView {

    private static final String KEY_USERNAME = "UserDetailFragment:username";
    @InjectView(R.id.vNoNetwork)
    NoNetworkView vNoNetwork;
    @InjectView(R.id.vProgressBar)
    ProgressBar vProgressBar;
    @InjectView(R.id.ivAvatar)
    ImageView ivAvatar;
    @InjectView(R.id.tvName)
    TextView tvName;
    @InjectView(R.id.tvEmail)
    TextView tvEmail;
    @InjectView(R.id.tvLocation)
    TextView tvLocation;
    @InjectView(R.id.tvFollowers)
    TextView tvFollowers;
    @InjectView(R.id.vMainContent)
    ScrollView vMainContent;

    @Inject
    ImageLoader imageLoader;

    UserDetailPresenter presenter;

    public String username;

    public static UserDetailFragment newInstance(String username) {
        final UserDetailFragment fragment = new UserDetailFragment();
        if (TextUtils.isEmpty(username)) {
            throw new NullPointerException("username must not be null or empty");
        }
        final Bundle args = new Bundle();
        args.putString(KEY_USERNAME, username);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Bundle args = getArguments();
        if (args != null) {
            username = args.getString(KEY_USERNAME);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_detail, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    protected void onInjected() {
        super.onInjected();
        setupLoading(vMainContent, vProgressBar);
        presenter = new UserDetailPresenter(username);
    }

    @Override
    protected void injectDependencies() {
        super.injectDependencies();
        ((UsersActivity) getActivity()).component().inject(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.onStart(this, ModelManager.getGitUserModel());
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.onStop();
        imageLoader.cancelTag(this);
    }

    @Override
    protected View getMainView() {
        return vMainContent;
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
    public void render(User user) {
        imageLoader.load(user.avatar_url, ivAvatar, R.drawable.ic_avatar_default, this);
        tvName.setText(user.name);
        tvEmail.setText(user.email);
        tvLocation.setText(user.location);
        tvFollowers.setText(user.followers);
    }

}
