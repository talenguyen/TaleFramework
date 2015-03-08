package com.tale.taleframework.services;

import dagger.Module;

/**
 * Created by tale on 3/8/15.
 */
@Module(
        injects = {
                Intent1.class,
                Intent2.class
        },
        complete = false
)
public class ServiceModule {
}
