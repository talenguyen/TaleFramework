package com.tale.mvp.presenter;

import com.tale.mvp.model.User;
import com.tale.mvp.model.UserModel;
import com.tale.mvp.rx.RxHelper;
import com.tale.mvp.view.UsersView;

import java.util.List;

import rx.Subscription;

/**
 * Created by Giang Nguyen on 4/2/2015.
 */
public class UsersPresenter implements BasePresenter<UsersView, UserModel> {

    private Subscription usersSubscription;

    @Override
    public void onStart(UsersView view, UserModel model) {
        view.showLoading(true);
        usersSubscription = model.getUsers()
                .compose(RxHelper.<List<User>>applySchedulers())
                .subscribe(users -> view.render(users),
                        e -> {
                            view.showLoading(false);
                            e.printStackTrace();
                        },
                        () -> view.showLoading(false));
    }

    @Override
    public void onStop() {
        if (usersSubscription != null) {
            usersSubscription.unsubscribe();
        }
    }
}
