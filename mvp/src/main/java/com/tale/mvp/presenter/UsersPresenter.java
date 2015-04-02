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
public class UsersPresenter extends BasePresenter<UsersView, UserModel> {

    private Subscription usersSubscription;

    public UsersPresenter(UsersView view, UserModel model) {
        super(view, model);
    }

    @Override
    public void onStart() {
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
        super.onStop();
        if (usersSubscription != null) {
            usersSubscription.unsubscribe();
        }
    }
}
