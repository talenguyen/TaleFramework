package com.tale.taleframework;

import android.content.Context;

import com.tale.taleframework.core.BaseApp;
import com.tale.taleframework.core.di.ApplicationModule;
import com.tale.taleframework.di.DaggerSingletonComponent;
import com.tale.taleframework.di.SingletonComponent;
import com.tale.taleframework.util.UtilModule;

/**
 * Created by tale on 3/8/15.
 */
public class App extends BaseApp {

    private SingletonComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerSingletonComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .utilModule(new UtilModule())
                .build();
    }

    public SingletonComponent component() {
        return component;
    }

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }

    @Override
    protected boolean isDebug() {
        return BuildConfig.DEBUG;
    }

}
