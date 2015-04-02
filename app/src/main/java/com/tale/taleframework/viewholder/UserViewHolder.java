package com.tale.taleframework.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tale.mvp.model.User;
import com.tale.taleframework.R;
import com.tale.taleframework.util.ImageLoader;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Giang Nguyen on 4/2/2015.
 */
public class UserViewHolder extends RecyclerView.ViewHolder {

    @InjectView(R.id.ivAvatar)
    ImageView ivAvatar;
    @InjectView(R.id.tvLogin)
    TextView tvLogin;

    public UserViewHolder(View itemView) {
        super(itemView);
        ButterKnife.inject(this, itemView);
    }

    public void bind(User user, ImageLoader imageLoader) {
        tvLogin.setText(user.login);
        imageLoader.load(user.avatar_url, ivAvatar);
    }
}
