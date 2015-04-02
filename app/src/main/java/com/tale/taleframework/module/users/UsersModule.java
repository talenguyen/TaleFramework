package com.tale.taleframework.module.users;

import android.view.LayoutInflater;

import com.tale.taleframework.activity.UsersActivity;
import com.tale.taleframework.fragment.UsersFragment;
import com.tale.taleframework.util.ImageLoader;
import com.tale.taleframework.util.PicassoImageLoader;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Giang Nguyen on 4/2/2015.
 */
@Module(
        injects = {
                UsersActivity.class,
                UsersFragment.class
        }
)
public class UsersModule {
    private final UsersActivity activity;

    public UsersModule(UsersActivity activity) {
        this.activity = activity;
    }

    @Provides
    public LayoutInflater provideLayoutInflater() {
        return activity.getLayoutInflater();
    }

    @Provides
    public ImageLoader provideImageLoader(PicassoImageLoader imageLoader) {
        return imageLoader;
    }
}
