package com.tale.taleframework;

import com.tale.taleframework.core.BaseApp;
import com.tale.taleframework.di.Modules;

/**
 * Created by tale on 3/8/15.
 */
public class App extends BaseApp {
    @Override protected boolean isDebug() {
        return BuildConfig.DEBUG;
    }

    @Override protected Object[] getModules() {
        return Modules.list(this);
    }
}
