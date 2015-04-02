package com.tale.taleframework.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.tale.mvp.model.User;
import com.tale.taleframework.R;
import com.tale.taleframework.core.ui.adapter.RecyclerTypedAdapter;
import com.tale.taleframework.util.ImageLoader;
import com.tale.taleframework.viewholder.UserViewHolder;

import javax.inject.Inject;

/**
 * Created by Giang Nguyen on 4/2/2015.
 */
public class UsersAdapter extends RecyclerTypedAdapter<User, UserViewHolder> {

    @Inject
    LayoutInflater layoutInflater;

    @Inject
    ImageLoader imageLoader;

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new UserViewHolder(layoutInflater.inflate(R.layout.item_user, parent, false));
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        holder.bind(getItem(position), imageLoader);
    }
}
