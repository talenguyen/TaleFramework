package com.tale.taleframework.loader;

import android.os.Handler;
import android.os.Looper;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by tale on 3/9/15.
 */
public class DataLoader<Result> {
    private final Map<String, Observer<Result>> observerMap = new LinkedHashMap<String, Observer<Result>>();
    private final Map<String, Result> resultMap = new LinkedHashMap<String, Result>();
    private String activeKey;
    private boolean isRunning;
    private Handler handler = new Handler(Looper.getMainLooper());

    public void register(String key, Observer observer) {
        if (key == null || observer == null) {
            throw new NullPointerException("key or observer must not be null");
        }

        if (isRunning && key.equals(activeKey)) {
            observer.onBeforeResult();
        }
        observerMap.put(key, observer);
        activeKey = key;
    }

    public void unRegister(String key) {
        if (key == null) {
            return;
        }
        observerMap.remove(key);
    }

    public void onBeforeResult() {
        handler.post(() -> {
            if (activeKey == null) {
                return;
            }
            final Observer observer = observerMap.get(activeKey);
            if (observer != null) {
                observer.onBeforeResult();
            }
            isRunning = true;
        });
    }

    public void onResult(Result o) {
        handler.post(() -> {
            if (activeKey == null) {
                return;
            }
            final Observer<Result> observer = observerMap.get(activeKey);
            if (observer == null) {
                resultMap.put(activeKey, o);
            } else {
                observer.onResult(o);
                observer.onCompleted();
            }
        });
    }

    public void onError(Throwable throwable) {
        handler.post(() -> {
            if (activeKey == null) {
                return;
            }
            final Observer<Result> observer = observerMap.get(activeKey);
            if (observer != null) {
                observer.onError(throwable);
                observer.onCompleted();
            }
        });
    }

}
