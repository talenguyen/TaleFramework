package com.tale.mvp.view;

import com.tale.mvp.model.User;

/**
 * Created by Giang Nguyen on 4/2/2015.
 */
public interface UserDetailView {
    /**
     * Show or hide loading progress.
     * @param show <b>true</b> to show or <b>false</b> to hide.
     */
    void showLoading(boolean show);

    /**
     * Render the user on UI
     * @param user the user to be rendered.
     */
    void render(User user);
}
