package com.tale.taleframework.services;

import android.app.IntentService;
import android.content.Intent;
import android.os.SystemClock;

import com.tale.taleframework.loader.DataLoader;
import com.tale.taleframework.loader.Loader;

/**
 * Created by tale on 3/10/15.
 */
public class StringLoaderService extends IntentService {

    public StringLoaderService() {
        super("StringLoaderService");
    }

    @Override protected void onHandleIntent(Intent intent) {
        final DataLoader<String> dataLoader = Loader.StringLoader.asDataLoader();
        dataLoader.onBeforeResult();
        SystemClock.sleep(3000);
        dataLoader.onResult("Hello, I am StringLoaderService");
    }
}
