package com.tale.taleframework.users;

import com.tale.taleframework.activity.UsersActivity;
import com.tale.taleframework.core.di.AbstractActivityComponent;
import com.tale.taleframework.core.di.ActivityModule;
import com.tale.taleframework.core.di.PerActivity;
import com.tale.taleframework.di.SingletonComponent;
import com.tale.taleframework.fragment.UsersFragment;

import dagger.Component;

/**
 * Created by tale on 4/23/15.
 */
@PerActivity
@Component(modules = ActivityModule.class, dependencies = {SingletonComponent.class})
public interface UsersComponent extends AbstractActivityComponent {
    void inject(UsersActivity activity);

    void inject(UsersFragment fragment);
}
