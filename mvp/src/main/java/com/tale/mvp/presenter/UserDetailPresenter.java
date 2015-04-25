package com.tale.mvp.presenter;

import com.tale.mvp.model.User;
import com.tale.mvp.model.UserModel;
import com.tale.mvp.rx.RxHelper;
import com.tale.mvp.view.UserDetailView;

import rx.Subscription;

/**
 * Created by Giang Nguyen on 4/2/2015.
 */
public class UserDetailPresenter implements BasePresenter<UserDetailView, UserModel> {

    private final String username;
    private Subscription userSubscription;

    public UserDetailPresenter(String username) {
        this.username = username;
    }


    @Override
    public void onStart(UserDetailView view, UserModel model) {
        view.showLoading(true);
        userSubscription = model.getUser(username)
                .compose(RxHelper.<User>applySchedulers())
                .subscribe(user -> view.render(user),
                        e -> {
                            view.showLoading(false);
                            e.printStackTrace();
                        },
                        () -> view.showLoading(false));
    }

    @Override
    public void onStop() {
        if (userSubscription != null) {
            userSubscription.unsubscribe();
        }
    }
}
