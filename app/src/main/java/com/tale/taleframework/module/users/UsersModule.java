package com.tale.taleframework.module.users;

import android.view.LayoutInflater;

import com.squareup.picasso.Picasso;
import com.tale.taleframework.activity.UsersActivity;
import com.tale.taleframework.fragment.UserDetailFragment;
import com.tale.taleframework.fragment.UsersFragment;
import com.tale.taleframework.util.EventBus;
import com.tale.taleframework.util.ImageLoader;
import com.tale.taleframework.util.OttoEventBus;
import com.tale.taleframework.util.PicassoImageLoader;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Giang Nguyen on 4/2/2015.
 */
@Module(
        injects = {
                UsersActivity.class,
                UsersFragment.class,
                UserDetailFragment.class
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

    @Singleton @Provides
    public ImageLoader provideImageLoader() {
        final Picasso picasso = Picasso.with(activity.getApplicationContext());
        picasso.setLoggingEnabled(true);
        return new PicassoImageLoader(picasso);
    }

    @Singleton @Provides
    public EventBus provideEventBus(OttoEventBus ottoEventBus) {
        return ottoEventBus;
    }
}
