package com.tale.taleframework.di;

import android.app.Application;

import com.tale.taleframework.core.di.ApplicationModule;
import com.tale.taleframework.util.EventBus;
import com.tale.taleframework.util.ImageLoader;
import com.tale.taleframework.util.UtilModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * A component whose lifetime is the life of the application.
 */
@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = {UtilModule.class, ApplicationModule.class})
public interface SingletonComponent {

    Application application();

    EventBus eventBus();

    ImageLoader imageLoader();

}