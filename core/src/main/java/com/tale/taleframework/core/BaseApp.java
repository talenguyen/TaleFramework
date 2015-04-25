package com.tale.taleframework.core;

import android.app.Application;

import com.tale.taleframework.core.compat.PlatformSpecificImplementationFactory;

import timber.log.Timber;

/**
 * Created by tale on 3/8/15.
 */
public abstract class BaseApp extends Application {

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
    }

    protected abstract boolean isDebug();

}
