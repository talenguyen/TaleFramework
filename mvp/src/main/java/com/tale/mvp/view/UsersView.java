package com.tale.mvp.view;

import com.tale.mvp.model.User;

import java.util.List;

/**
 * Created by Giang Nguyen on 4/2/2015.
 */
public interface UsersView {

    /**
     * Show or hide loading progress.
     * @param show <b>true</b> to show or <b>false</b> to hide.
     */
    void showLoading(boolean show);

    /**
     * Render a list of user on UI
     * @param users the users to be rendered.
     */
    void render(List<User> users);
}
