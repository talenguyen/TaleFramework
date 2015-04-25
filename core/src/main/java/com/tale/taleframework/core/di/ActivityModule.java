package com.tale.taleframework.core.di;

import android.app.Activity;
import android.view.LayoutInflater;

import dagger.Module;
import dagger.Provides;

/**
 * A module to wrap the Activity state and expose it to the graph.
 */
@Module
public class ActivityModule {
    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    /**
     * Expose the activity to dependents in the graph.
     */
    @Provides
    @PerActivity
    Activity provideActivity() {
        return activity;
    }

    @Provides
    @PerActivity
    public LayoutInflater provideLayoutInflater() {
        return activity.getLayoutInflater();
    }
}