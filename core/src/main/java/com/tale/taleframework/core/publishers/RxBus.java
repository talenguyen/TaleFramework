package com.tale.taleframework.core.publishers;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * Created by tale on 3/8/15.
 */
public class RxBus {

    private final Subject<Object, Object> rxBus = new SerializedSubject<>(PublishSubject.create());

    public RxBus() {
    }

    public void send(Object object) {
        if (rxBus.hasObservers()) {
            rxBus.onNext(object);
        }
    }

    public Observable<Object> asObservable() {
        return rxBus;
    }

}