package com.tale.taleframework.core;

import android.app.Application;
import android.content.Context;

import com.tale.taleframework.core.compat.PlatformSpecificImplementationFactory;

import dagger.ObjectGraph;
import timber.log.Timber;

/**
 * Created by tale on 3/8/15.
 */
public abstract class BaseApp extends Application {

    private ObjectGraph objectGraph;

    @Override public void onCreate() {
        super.onCreate();
        objectGraph = ObjectGraph.create(getModules());

        if (isDebug()) {
            Timber.plant(new Timber.DebugTree());
            // Enable strictMode for development. This will help to keep project in high quality.
            PlatformSpecificImplementationFactory.getStrictMode().enableStrictMode();
        } else {
//            Timber.plant(new CrashReportingTree());
        }
    }

    protected abstract boolean isDebug();

    protected abstract Object[] getModules();

    public ObjectGraph plus(Object... modules) {
        return objectGraph.plus(modules);
    }

    public static BaseApp get(Context context) {
        return (BaseApp) context.getApplicationContext();
    }
}
