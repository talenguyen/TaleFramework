package com.tale.taleframework.di;

import android.app.Application;

import com.tale.taleframework.core.di.RootModule;

/**
 * Created by tale on 3/8/15.
 */
public class Modules {
    private Modules() {
    }

    public static Object[] list(Application application) {
        return new Object[] {
               new RootModule(application)
        };
    }
}
