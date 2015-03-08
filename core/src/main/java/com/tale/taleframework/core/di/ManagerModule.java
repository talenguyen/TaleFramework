package com.tale.taleframework.core.di;

import com.tale.taleframework.core.publishers.RxBus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tale on 3/8/15.
 */
@Module(
        library = true
)
public class ManagerModule {
    @Provides @Singleton RxBus provideBus() {
        return new RxBus();
    }
}
