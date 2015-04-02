package com.tale.taleframework.util;

/**
 * Created by Giang Nguyen on 4/2/2015.
 */
public interface EventBus {

    void register(Object object);

    void unregister(Object object);

    void post(Object object);

}
