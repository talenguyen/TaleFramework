package com.tale.taleframework.core.di;

import android.app.Application;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tale on 3/8/15.
 */
@Module(
        library = true,
        includes = {
                ManagerModule.class
        }
)
public class RootModule {
    private Application application;

    public RootModule(Application application) {
        this.application = application;
    }

    @Provides Application provideApplication() {
        return application;
    }
}
