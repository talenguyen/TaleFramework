package com.tale.taleframework.services;

import android.app.IntentService;
import android.content.Intent;
import android.os.SystemClock;

import com.tale.taleframework.core.BaseApp;
import com.tale.taleframework.core.publishers.RxBus;

import javax.inject.Inject;

import dagger.ObjectGraph;
import timber.log.Timber;

/**
 * Created by tale on 3/8/15.
 */
public class Intent2 extends IntentService {
    @Inject RxBus bus;

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     */
    public Intent2() {
        super("Intent2");
    }

    @Override public void onCreate() {
        super.onCreate();
        injectDependencies();
        Timber.d("onCreate");
    }
    private void injectDependencies() {
        final ObjectGraph plus = BaseApp.get(this).plus(new ServiceModule());
        plus.inject(this);
    }

    @Override protected void onHandleIntent(Intent intent) {
        bus.send("started");
        Timber.d("started");
        SystemClock.sleep(3000);
        bus.send("destroyed");
        Timber.d("destroyed");
    }
}
