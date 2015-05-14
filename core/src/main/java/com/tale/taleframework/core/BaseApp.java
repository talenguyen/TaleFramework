package com.tale.taleframework.core;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import com.tale.taleframework.core.compat.PlatformSpecificImplementationFactory;

import timber.log.Timber;

/**
 * Created by tale on 3/8/15.
 */
public abstract class BaseApp extends Application {

    private RefWatcher refWatcher;

    @Override
    public void onCreate() {
        super.onCreate();

        if (isDebug()) {
            Timber.plant(new Timber.DebugTree());
            // Enable strictMode for development. This will help to keep project in high quality.
            PlatformSpecificImplementationFactory.getStrictMode().enableStrictMode();
        } else {
//            Timber.plant(new CrashReportingTree());
        }

        refWatcher = LeakCanary.install(this);
    }

    public static RefWatcher getRefWatcher(Context context) {
        return ((BaseApp) context.getApplicationContext()).refWatcher;
    }

    protected abstract boolean isDebug();

}
