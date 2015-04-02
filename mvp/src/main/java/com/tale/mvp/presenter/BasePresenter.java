package com.tale.mvp.presenter;

/**
 * Created by Giang Nguyen on 4/2/2015.
 */
public abstract class BasePresenter<V, M> {

    public V view;
    public M model;

    public BasePresenter(V view, M model) {
        this.view = view;
        this.model = model;
    }

    /**
     * Start the presenter
     */
    public abstract void onStart();

    /**
     * Stop the presenter
     */
    public void onStop() {
        view = null;
        model = null;
    }

}
